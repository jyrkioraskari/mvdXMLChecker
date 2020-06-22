# mvdXML Checker
v2.17


The mvdXMLChecker is a generic tool for verifying IFC models. I
The validation rules are defined in the mvdXML schema. The software produces a BIM Collabolarion Format (BCF) report that can be used in BIM tools like Solibri to review the viewpoints, 
and the comment of the validation issues found.

References:
1. Model Support Group (MSG) of buildingSMART International Ltd.
Specification of a standardized format to define and exchange
Model View Definitions with Exchange Requirements and Validation Rules.
Version 1.1 Final. 15. 02. 2016


Supported mvdXML versions are V1.1. V1-1 and v1.2 draft 3.

Precompiled binaries that can be used at a web application server can be found here: 
https://github.com/jyrkioraskari/OnlineMvdXMLChecker/releases

Tomcat 9 (https://tomcat.apache.org/download-90.cgi) was used as an application server for the tests.


This code is based on the original work of Chi Zhang in: 	
https://github.com/BenzclyZhang/mvdXMLChecker


The test Open API interface can be found here:
http://lbd.arch.rwth-aachen.de/mvdXMLChecker/apidocs/


## A Sample Python client source

Python 3.8.  Needed modules: requests
```
import requests
import json
from pathlib import Path

ifc_file_path = 'C:/test/Duplex_A_20110505.ifc'
mvdxml_file_path = 'C:/test/Simple.mvdxml'

ifc_file = open(ifc_file_path, 'rb')
mvdxml_file = open(mvdxml_file_path, 'rb')

files = {"ifcFile": (ifc_file_path, ifc_file),"mvdXMLfile": (mvdxml_file_path, mvdxml_file)}
headers={}

resp = requests.post("http://lbd.arch.rwth-aachen.de/mvdXMLChecker/api/check_plain", files=files, headers=headers )
print(resp.text)
print("status code " + str(resp.status_code))

if resp.status_code == 200:
    print ("Success")
    data = json.loads(resp.text)
else:
    print ("Failure")
```


BCF Download
```
import requests
from pathlib import Path

ifc_file_path = 'c:\\temp\\A.ifc'
mvdxml_file_path = 'c:\\temp\\A.mvdxml'

ifc_file = open(ifc_file_path, 'rb')
mvdxml_file = open(mvdxml_file_path, 'rb')

files = {"ifcFile": (ifc_file_path, ifc_file),"mvdXMLfile": (mvdxml_file_path, mvdxml_file)}
headers={}
resp = requests.post("http://lbd.arch.rwth-aachen.de/mvdXMLChecker/api/check", files=files, headers=headers )
print("status code " + str(resp.status_code))

if resp.status_code == 200:
    print ("Success")
    bcf_file = open("c:\\temp\\results.bcfzip", "wb")
    bcf_file.write(bytearray(resp.content))
    bcf_file.close()
else:
    print ("Failure")

```

https://github.com/jyrkioraskari/OnlineMvdXMLChecker/tree/master/mvdXMLCheckerClient_Python


## Docker
Docker (https://www.docker.com/) installations are available for the interfaces. A client for a desktop computer can be installed from https://www.docker.com/products/docker-desktop . 

### Docker for the Open API interface

![Open API](https://raw.githubusercontent.com/jyrkioraskari/OnlineMvdXMLChecker/master/doc/mvdXMLAPI.png)


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

## The command-line tool

```
Usage: java -jar MvdXMLCommandLineChecker.jar -ifc <file> -mvdXML <file>

 -ifc <file>      The Industry Foundation Classes (IFC) file to be tested.
                  Versions IFC2x3, and IFC4 are supported.
 -mvdXML <file>   The mvdXML (Model View Definitions with Exchange
                  Requirements and Validation Rules) definition file for
                  the validation.
```
## Installation commands in Linux

```
sudo cp  mvdXMLChecker.war /var/lib/tomcat8/webapps
suco chmod 777 /var/lib/tomcat8/webapps/mvdXMLChecker.war
sudo systemctl restart tomcat8 
```

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

## Acknowledgements
This research was funded by the EU through the H2020 project BIM4REN.


