# docker-textanalysis-audreyt
This is a project to follow-up adureyt's (唐鳳) archive.tw content 


## Command to run 

```
docker build -t myimage .
docker run -d --name mycontainer -p 80:80 myimage
```

- Run a container based on your image, mapping your code directory (./app) to your container's /app directory: bash

```
docker run -d --name mycontainer -p 80:80 -v $(pwd)/app:/app myimage
```

or 

```
docker run -d --name mycontainer -p 80:80 -v $(pwd)/app:/app myimage bash -c "while true ; do sleep 10 ; done"
docker exec -it mycontainer bash
python main.py
```

## Concept to be intrdouced
- [ ] Single Page Application

## References
1. [docker-misconceptions](https://valdhaus.co/writings/docker-misconceptions/)