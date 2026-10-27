package com.jenkins.gke_demo.comtroller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VersionController {

    @Value("${app.version:1.0.0}")
    private String version;

    @GetMapping("/version")
    public Map<String, String> getVersion() {
        return Map.of(
            "application OF Maharshi", "jenkins-gke-demo",
            "version", version,
            "message", "Hello from GKE!"
        );
    }
}

