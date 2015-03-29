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

var result = document.getElementById("jsonObj").value;
var index = document.getElementById("index").value;

// for(i=1;i<37;i++){
// alert(obj[i]);
// }

var myArr = new Array(index);
// var index = 0;
var obj = JSON.parse(result) ;
for(i=0;i<index;i++){
	
// 	alert(obj[i].toString());

			var string = obj[i];
			myArr[i] = new Array(3);
			var sp = string.split("|");

			myArr[i][0] = sp[0];
			myArr[i][1] = sp[1];
			myArr[i][2] = sp[2];
			
// 			index = index+1;
  }
  
// alert(myArr.length);

// for (i = 0; i < myArr.length; i++) {   
	
// 	alert(myArr[i][0]);
// 	alert(myArr[i][1]);
// 	alert(myArr[i][2]);
// }


 var image = 'img/restaurant.png';
 var map = new google.maps.Map(document.getElementById("map_container"), {
      zoom: 10,
      center: new google.maps.LatLng(42.30008,-83.01654),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < myArr.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(myArr[i][1], myArr[i][2]),
        map: map,
        icon: image
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(myArr[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }


  }
</script>
</head>
 
<body onload="loadMap()">
<s:form id="restaurantForm" action="displayRestaurantsAction" enctype="multipart/form-data" method="POST">
<s:hidden name="allAddressResult" value ="%{allAddressResult}" id="allAddressResult"></s:hidden>
<s:hidden name="jsonObj" value ="%{jsonObj}" id="jsonObj"></s:hidden>
<s:hidden name="index" value ="%{index}" id="index"></s:hidden>
<s:div id="map_container"></s:div>


</s:form>
</body>
 
</html>