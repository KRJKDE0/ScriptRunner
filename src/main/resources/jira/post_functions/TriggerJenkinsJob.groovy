def  issuekey=issue.getKey()
def issueReporter=issue.getReporter()
def issueReporterMail=issueReporter.getEmailAddress()


def baseurl = "http://jenkins.net:8080/buildByToken/buildWithParameters?job=job_path&token=singletickettoken&ticket=${issuekey}&email=${issueReporterMail}"

def connection=new URL(baseurl).openConnection() as HttpURLConnection
    connection.setRequestMethod( "POST" )
               connection.doOutput = true
               connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8")
               connection.getOutputStream().write()
               connection.connect()
def connection_response_code = connection.getResponseCode();
def connection_response_text=connection.getInputStream().getText()
log.debug  "Post Function Log ${connection_response_code} ${baseurl}"
