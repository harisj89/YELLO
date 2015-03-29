<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>60-611-Assignment 3(Haris J.)</title>

<style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
      #panel {
        position: absolute;
        top: 5px;
        left: 50%;
        margin-left: -180px;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
      }
    </style>
    <style>
      #directions-panel {
        height: 100%;
        float: right;
        width: 390px;
        overflow: auto;
      }

      #map-canvas {
        margin-right: 400px;
      }

      #control {
        background: #fff;
        padding: 5px;
        font-size: 14px;
        font-family: Arial;
        border: 1px solid #ccc;
        box-shadow: 0 2px 2px rgba(33, 33, 33, 0.4);
        display: none;
      }

      @media print {
        #map-canvas {
          height: 500px;
          margin: 0;
        }

        #directions-panel {
          float: none;
          width: auto;
        }
      }
    </style>
<script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?libraries=weather,geometry&sensor=true_or_false&key=AIzaSyDBl3_6LVk0J7fgoBHWUTWktaDvIHBmltA&signed_in=true&v=3.exp">
</script>

    <script>
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();

function initialize() {
  directionsDisplay = new google.maps.DirectionsRenderer();
  var mapOptions = {
    zoom: 7,
    center: new google.maps.LatLng(42.30008, -83.01654)
  };
  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
  directionsDisplay.setMap(map);
  directionsDisplay.setPanel(document.getElementById('directions-panel'));

  var control = document.getElementById('control');
  control.style.display = 'block';
  map.controls[google.maps.ControlPosition.TOP_CENTER].push(control);
}

function calcRoute() {
  var start = document.getElementById('start').value;
  var end = document.getElementById('end').value;
	
//   alert(document.getElementById('start').value);
//   var start = "toronto,ON";
//   var end = "windsor, ON";


  var request = {
    origin: start,
    destination: end,
    travelMode: google.maps.TravelMode.DRIVING
  };
  directionsService.route(request, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
    }
    else{ 
    	alert("Sorry please try again.");
    }
  });
}

function validate(){ 
	var start = document.getElementById('start').value;
	  var end = document.getElementById('end').value;

	  if(start != '' && end != ''){ 
		  calcRoute();
	  }
	  else{
		  alert("Enter Both Start and End values.");
	  }
}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>


</head>
 <body>
 <div> Enter starting and end location address to know directions</div>
 <hr>
    <div id="control">
      <strong>Start:</strong>
     <input type="text" name="start" onkeydown="if (event.keyCode == 13) { validate();}" id="start">
      <strong>End:</strong>
      <input type="text" name="start" onkeydown="if (event.keyCode == 13) { validate();}" id="end">
       <input type="button" name="calRoute" value="Submit" onclick="validate();"> 
    </div>
    <div id="directions-panel"></div>
    <div id="map-canvas"></div>
  </body>

</html>