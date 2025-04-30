# docker configurations step

## create docker file

1. `touch Dockerfile`
2. `add configuraions`

## build a docker image name 26658/assignment_one

`docker build -t 26658/assignement_one .`

## running app

### run default which is assignment one

`docker run -it 26658/assignement_one`

### run assignment two

`run -it 26658/assignement_one assignment_two.HotelDemo`

### run assignment three

`docker run -it 26658/assignement_one assignment_three.Main`

## Pushing to Docker hub

### Login

`docker login -u alinegwizaigihozo`

### Tag an image with tag name you wish

`docker tag 26658/assignment_one alinegwizaigihozo/assignment`

## push to the docker repository

`docker push alinegwizaigihozo/assignment`

## Docker Hub repository URL

`https://hub.docker.com/r/alinegwizaigihozo/assignment`
