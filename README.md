# docker-textanalysis-audreyt
This is a project to follow-up adureyt's (唐鳳) archive.tw content 


## Command to run 

### Build 

```
docker build -t textanalysis-andreyt .
docker run -d --name mycontainer -p 80:80 textanalysis-andreyt
```

### Run a container based on your image, mapping your code directory (./app) to your container's /app directory: bash

```
#Devlopment Setting 將外部開發目錄Mount至Container目錄
docker run -d --name mycontainer -p 80:80 -v $(pwd)/app:/app textanalysis-andreyt
```

or 

```
#Devlopment Setting 將外部開發目錄Mount至Container目錄，而且可以隨時重啟
docker run -d --name mycontainer -p 80:80 -v $(pwd)/app:/app myimage bash -c "while true ; do sleep 10 ; done"
docker exec -it mycontainer bash
python main.py
```

### Publish to [docker-hub](https://hub.docker.com/) 
> lin1000/opengov:python3.6 {username}/{repository}:{tag}

```
#tag為Python3.6為辨識該Container使用程式語言版本的好方法
docker tag textanalysis-andreyt lin1000/opengov:python3.6
docker push lin1000/opengov:python3.6
```

## Concept to be intrdouced
- [ ] Prepare a template for Single Page Application

## References
1. [docker-misconceptions](https://valdhaus.co/writings/docker-misconceptions/)