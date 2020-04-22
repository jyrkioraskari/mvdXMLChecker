# mvdXML Checker
Online mvdXMLChecker: Use mvdXML to validate IFC models


This code is based on the original work of Chi Zhang in: 	
https://github.com/BenzclyZhang/mvdXMLChecker


The test Open API interface can be found here:
http://lbd.arch.rwth-aachen.de/mvdXMLChecker/apidocs/

## Docker
Docker (https://www.docker.com/) installations are available for the interfaces. A client for your desktop can be installed from: https://www.docker.com/products/docker-desktop . 

### Docker for the Open API interface

docker pull jyrkioraskari/api4mvdxmlchecker:latest

docker container run -it --publish 8081:8080 jyrkioraskari/api4mvdxmlchecker

http://localhost:8081/

### Docker for the Web interface

docker pull jyrkioraskari/webui4mvdxmlchecker:latest

docker container run -it --publish 8084:8080 jyrkioraskari/webui4mvdxmlchecker

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

