var map;
var marker = null;

function initMap() {
    var uluru = {lat: -25.363, lng: 131.044};
    map = new google.maps.Map(document.getElementById('map'), {
    center: uluru,
    zoom: 4,
    streetViewControl: false,
    mapTypeControl: false,
    
  });
}

function loadCities() {
    $.getJSON('cities/ajax', {'command': 'get_cities'}, function (data) {
        var dropdown = $("#myDropdown");
        
        dropdown.empty();
        
        $.each(data, function (i, city) {
            $('<a>', { 
                "class": 'dropbtnopt',
                text : city
            }).appendTo(dropdown)
        })
    })
};

function myFunction() {
    loadCities();
    document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function(event) {
    if (event.target.matches('.dropbtnopt')) {
        
        var cityButton = document.getElementById('selected-city-button');
        var cityName = event.target.innerHTML;

        cityButton.innerHTML = cityName;

        // reset dropdown
        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];

            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
        
        generateInfo(cityName);
    }
}

function generateInfo(cityName) {
    
    $.getJSON('cities/ajax', {'command': 'get_info', 'city_name': cityName}, function (data) {
        var loc = {lat: data.lat, lng: data.lng};
        
        map.setCenter(loc);
        
        
        if (marker !== null){
            marker.setMap(null);
        }
        
        marker = new google.maps.Marker({
            position: loc,
            map: map
        });
        
        google.maps.event.trigger(map, 'resize');
       
        document.getElementById('distance_text').innerHTML = "Disatnce from PG ETI " + data.distance;
        document.getElementById('weather_text').innerHTML = data.weather;
        
        document.getElementById("my_dropdown_bottom").classList.toggle("show");
    })
};

$(document).ready(function () {
    
});
            