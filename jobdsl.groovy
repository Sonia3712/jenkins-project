job('build-job') {
    description('Build job using Maven')

    scm {
        git('https://github.com/Sonia3712/jenkins-project.git')
    }

    steps {
        maven('clean package')
    }

    publishers {
        archiveArtifacts('**/*.war')
        downstream('deploy-job', 'SUCCESS')
    }
}

job('deploy-job') {
    description('Deploy job to Tomcat')

    steps {
        shell('echo Deploying project...')
    }
}
