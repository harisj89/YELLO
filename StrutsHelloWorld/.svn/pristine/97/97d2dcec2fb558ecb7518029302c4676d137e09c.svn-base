<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<style type="text/css">
div#map_container{
	width:100%;
	height:350px;
/* 	padding-top: 5px; */
}
</style>
<script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?libraries=weather,geometry&sensor=true_or_false&key=AIzaSyDBl3_6LVk0J7fgoBHWUTWktaDvIHBmltA&signed_in=true">
</script>
 
<script type="text/javascript">
  function loadMap() {
// 	 var image = 'img/restaurant.png';
//     var latlng = new google.maps.LatLng(42.30008,-83.01654);
//     var myOptions = {
//       zoom: 17,
//       center: latlng,
//       mapTypeId: google.maps.MapTypeId.ROADMAP
//     };
//     var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
 
//     var marker = new google.maps.Marker({
//       position: latlng, 
//       map: map, 
//       title:"Windsor",
//       icon: image
//     });
    
//     marker.setMap(map);
    
//     var transitLayer = new google.maps.TransitLayer();
// 	 transitLayer.setMap(map);



var locations = [
      ['Bondi Beach', -33.890542, 151.274856, 4],
      ['Coogee Beach', -33.923036, 151.259052, 5],
      ['Cronulla Beach', -34.028249, 151.157507, 3],
      ['Manly Beach', -33.80010128657071, 151.28747820854187, 2],
      ['Maroubra Beach', -33.950198, 151.259302, 1]
    ];

    var map = new google.maps.Map(document.getElementById("map_container"), {
      zoom: 10,
      center: new google.maps.LatLng(-33.92, 151.25),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
 
  }
</script>
</head>
 
<body onload="loadMap()">
<s:div id="map_container"></s:div>
</body>
 
</html>