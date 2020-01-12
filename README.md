# Overview
API that encapsulates running of Nmap scanner (for now).

# Some product goals for this
- Be able to scan hosts from a mobile phone using main network enumeration tools like nmap, dig, etc. This API has an Angular client that will allow me to scan hosts with Nmap, dig and other tools from my phone once this is deployed. I know there are services that do that, but this is not important for a personal development project.
- Have a functionality to show close to real time changes in opened ports of a given host. I don't know if it's really practical about it, but it seems cool.
- Have simple insights into what services are running on a given host in-browser. For example, if there is a Samsung TV opening ports via UPnP on some host, have Crows Nest tell the user about that.

# Why do this?
To accomplish a few personal goals:
- Mainly, to have a small project that's easy to modify and add new features to. For example, current simple queue functionality can be replaced with a third-party service that can do queing like SQS or Kafka or anything else. Or I can rewrite the API in NestJS or Closure or Rust, just 'cause I want to learn something. This way I don't need to come up with a theme again for "what to build".
- Learn about full stack development (the client app of this), async webservices, queueing, Spring Boot details, Docker, etc. All the regular stuff these days.

# Requirements to run
- Java 8+
- Gradle 6+
- Nmap
