import requests
import json
from pathlib import Path



ifc_file_path = 'C:/test/Duplex_A_20110505.ifc'
mvdxml_file_path = 'C:/test/Simple.mvdxml'

ifc_file = open(ifc_file_path, 'rb')
mvdxml_file = open(mvdxml_file_path, 'rb')


files = {"ifcFile": (ifc_file_path, ifc_file),"mvdXMLfile": (mvdxml_file_path, mvdxml_file)}
headers={}
resp = requests.post("http://lbd.arch.rwth-aachen.de/mvdXMLChecker/api/check", files=files, headers=headers )
print(resp.text)
print("status code " + str(resp.status_code))

if resp.status_code == 200:
    print ("Success")
    data = json.loads(resp.text)
else:
    print ("Failure")