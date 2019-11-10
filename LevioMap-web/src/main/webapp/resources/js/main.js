$(document).ready(function() {
var map = new ol.Map({
        view: new ol.View({center: ol.proj.transform([16.9278, 52.4044], 'EPSG:4326', 'EPSG:3857'), zoom:12}),
        layers: [new ol.layer.Tile({
                source: new ol.source.OSM()
        })],
        target:'map'
    });


    var style = new ol.style.Style({
	    image: new ol.style.Circle({
	    	radius: 7,
	      	stroke: new ol.style.Stroke({
		      	color: '#ff2121',
		      	width: 3
	    	}),
	      	fill: new ol.style.Fill({
	        	color: 'rgba(255,33,33, 0)'
	      	})
	    })
  	});

  	

    var marker = new ol.Feature({
        geometry: new ol.geom.Point(ol.proj.transform([16.9071388, 52.4901917], 'EPSG:4326', 'EPSG:3857')),
        text : 'Client x'
            
    });


    
    var markers = new ol.source.Vector({
        features: [marker]
    });


    
    var markerVectorLayer = new ol.layer.Vector({
        source: markers,
        style:style
    });
    map.addLayer(markerVectorLayer);


    var element = $('#popup');
    
      var popup =  new  ol.Overlay ({
  		element : element,
  		stopEvent :  false
	});

	map.addOverlay (popup);

	

	map.on('click', function(evt) {
		
		var feature = map.forEachFeatureAtPixel(evt.pixel,
			function(feature, layer) {
				return feature;
			});

		if (feature) {
			var coordinate = feature.getGeometry().getCoordinates();
			element.show();
			element.html(feature.get('text') + ol.coordinate.toStringHDMS(ol.proj.transform(coordinate, 'EPSG:3857', 'EPSG:4326')));
			popup.setPosition(coordinate);
		} else {
			element.hide();
		}

	});
     
});