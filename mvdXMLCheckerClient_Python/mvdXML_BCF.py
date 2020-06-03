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