#------------------- depend ubuntu
FROM ubuntu:14.04

MAINTAINER pkwenda "sis.nonacosa@gmail.com"

WORKDIR /app/

COPY . /app/


RUN echo deb http://archive.ubuntu.com/ubuntu precise universe > /etc/apt/sources.list.d/universe.list
RUN apt-get update && apt-get install -y wget git curl zip monit openssh-server git iptables ca-certificates daemon net-tools libfontconfig-dev && apt-get install vim



#-------------------- JDK
RUN echo "# Installing Oracle JDK 8" && \
    sudo apt-get install -y software-properties-common debconf-utils && \
    sudo add-apt-repository -y ppa:webupd8team/java && \
    sudo apt-get update && \
    echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | sudo debconf-set-selections && \
    sudo apt-get install -y oracle-java8-installer && \
    Java -version ; if [ $? = 0 ] ; then echo "java is installed" ; else echo "java is not installed" ;  exit 1; fi



# ------------- MAVEN
# ENV MAVEN_ROOT /var/lib/maven
# ENV MAVEN_HOME $MAVEN_ROOT/apache-maven-$MAVEN_VERSION
# ENV MAVEN_OPTS -Xms256m -Xmx512m

# RUN echo "# Installing Maven " && echo ${MAVEN_VERSION} && \
#     wget --no-verbose -O /tmp/apache-maven-$MAVEN_VERSION.tar.gz \
#     http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
#     mkdir -p $MAVEN_ROOT && \
#     tar xzf /tmp/apache-maven-$MAVEN_VERSION.tar.gz -C $MAVEN_ROOT && \
#     ln -s $MAVEN_HOME/bin/mvn /usr/local/bin && \
#     rm -f /tmp/apache-maven-$MAVEN_VERSION.tar.gz

# VOLUME /var/lib/maven


# ------------ NODE

# RUN echo "# Installing Nodejs" && \
#     curl -sL https://deb.nodesource.com/setup_8.x | bash - && \
#     apt-get install nodejs build-essential -y && \
#     npm install -g cnpm --registry=https://registry.npm.taobao.org && \
#     npm set strict-ssl false && \
#     npm cache clear -f && \
#     npm install -g n && \
#     n stable

# ----------- NEW-BEE-SHELL - no redundant RUN ↑
