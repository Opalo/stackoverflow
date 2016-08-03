FROM python:3.4
ENV PYTHONBUFFERED 1
WORKDIR /tasker
ADD requirements.txt /tasker/
RUN pip install -r requirements.txt
ADD . /tasker/
