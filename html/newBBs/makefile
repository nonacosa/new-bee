default: help

help: 
	@echo "python2 users:  make py2"
	@echo "python3 users:  make py3"

py2:
	python -m SimpleHTTPServer 8088
	open http://localhost:8088

py3:
	python -m http.server 8021
	open http://localhost:8021
