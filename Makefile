NAME ?= console-drawing
IMAGE ?= vdimitrov/$(NAME)
TAG ?= latest

install: 
	@mvn clean package

run: install
	@java -jar ./target/console-drawing-1.0.0.jar

docker-build:
	docker build -t $(IMAGE):$(TAG) .

docker-push: docker-build
	docker push $(IMAGE):$(TAG)