FROM docker.io/library/tomcat:9-jre11

LABEL maintainer="eslamzain99"
LABEL app="java-docker-demo"

# Remove default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Create required directories
RUN mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/classes

# Copy compiled Java classes (simple demo - no Maven yet)
COPY . /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/

# Expose Tomcat port
EXPOSE 8080

# Run Tomcat
CMD ["catalina.sh", "run"]
