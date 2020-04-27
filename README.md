# mvdXML Checker
v1.7

The mvdXML Checker is a tool for verifying IFC models. The validation
rules are defined in the mvdXML schema (1). The software produces a BCF
report and a list of the found issues. These BCFfiles can be opened with
Solibri to review the viewpoints, and the comment of the validation issues
found.

References:
1. Model Support Group (MSG) of buildingSMART International Ltd.
Specification of a standardized format to define and exchange
Model View Definitions with Exchange Requirements and Validation Rules.
Version 1.1 Final. 15. 02. 2016

Precompiled binaries that can be used at a web application server can be found here: 
https://github.com/jyrkioraskari/OnlineMvdXMLChecker/releases/tag/1.4

Tomcat 9 (https://tomcat.apache.org/download-90.cgi) was used as an application server for the tests.


This code is based on the original work of Chi Zhang in: 	
https://github.com/BenzclyZhang/mvdXMLChecker


The test Open API interface can be found here:
http://lbd.arch.rwth-aachen.de/mvdXMLChecker/apidocs/

## Docker
Docker (https://www.docker.com/) installations are available for the interfaces. A client for a desktop computer can be installed from https://www.docker.com/products/docker-desktop . 

### Docker for the Open API interface

Command-line commands needed to start the server at your computer;
```
docker pull jyrkioraskari/api4mvdxmlchecker:latest

docker container run -it --publish 8081:8080 jyrkioraskari/api4mvdxmlchecker

```
Then the software can be accessed from the local web address:
http://localhost:8081/

### Docker for the Web interface

Command-line commands needed to start the server at your computer;
```
docker pull jyrkioraskari/webui4mvdxmlchecker:latest

docker container run -it --publish 8084:8080 jyrkioraskari/webui4mvdxmlchecker

```


Then the software can be accessed from the local web address:
http://localhost:8084/


## Cite this
```
@software{jyrki_oraskari_2020_3760756,
  author       = {Jyrki Oraskari},
  title        = {{jyrkioraskari/OnlineMvdXMLChecker: mvdXML Checker 
                   for mvdXML 1.1}},
  month        = apr,
  year         = 2020,
  publisher    = {Zenodo},
  version      = {1.4},
  doi          = {10.5281/zenodo.3760756},
  url          = {https://doi.org/10.5281/zenodo.3760756}
}
```

