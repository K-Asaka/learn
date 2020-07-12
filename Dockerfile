FROM centos:centos7

RUN curl -sSL https://get.haskellstack.org/ | sh

RUN stack upgrade
RUN stack --version

RUN stack setup

