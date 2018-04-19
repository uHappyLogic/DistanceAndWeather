function initMap() {
  var uluru = {lat: -25.363, lng: 131.044};
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 4,
    center: uluru,
    streetViewControl: false,
    mapTypeControl: false
  });

  var marker = new google.maps.Marker({
    position: uluru,
    map: map
  });
}

function loadCities() {
    $.getJSON('cities/ajax', {'command': 'get_cities'}, function (data) {
        var dropdown = $("#myDropdown");

        $.each(data, function (i, city) {
            $('<a>', { 
                "class": 'dropbtnopt',
                text : city
            }).appendTo(dropdown)
        })
    })
};

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function(event) {
    if (event.target.matches('.dropbtnopt')) {
        var cityButton = document.getElementById('city-button');
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
    }
}

$(document).ready(function () {
    loadCities();
});
            