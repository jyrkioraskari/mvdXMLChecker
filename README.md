# mvdXML Checker
Online mvdXMLChecker: Use mvdXML to validate IFC models


This code is based on the original work ot Chi Zhang in: 	
https://github.com/BenzclyZhang/mvdXMLChecker


The test Open API interface can be found here:
http://lbd.arch.rwth-aachen.de/mvdXMLChecker/apidocs/

## Docker
Docker installations are available for the intarfaces

## Docker for the Open API interface

docker pull jyrkioraskari/api4mvdxmlchecker:latest

docker container run -it --publish 8081:8080 jyrkioraskari/api4mvdxmlchecker

http://localhost:8081/


