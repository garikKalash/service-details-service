@REM ----------------------------------------------------------------------------
@REM  Copyright 2001-2006 The Apache Software Foundation.
@REM
@REM  Licensed under the Apache License, Version 2.0 (the "License");
@REM  you may not use this file except in compliance with the License.
@REM  You may obtain a copy of the License at
@REM
@REM       http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM  Unless required by applicable law or agreed to in writing, software
@REM  distributed under the License is distributed on an "AS IS" BASIS,
@REM  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM  See the License for the specific language governing permissions and
@REM  limitations under the License.
@REM ----------------------------------------------------------------------------
@REM
@REM   Copyright (c) 2001-2006 The Apache Software Foundation.  All rights
@REM   reserved.

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup
set REPO=


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\org\springframework\boot\spring-boot-starter-web\1.5.2.RELEASE\spring-boot-starter-web-1.5.2.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter\1.5.2.RELEASE\spring-boot-starter-1.5.2.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot\1.5.2.RELEASE\spring-boot-1.5.2.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-autoconfigure\1.5.2.RELEASE\spring-boot-autoconfigure-1.5.2.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-logging\1.5.2.RELEASE\spring-boot-starter-logging-1.5.2.RELEASE.jar;"%REPO%"\ch\qos\logback\logback-classic\1.1.11\logback-classic-1.1.11.jar;"%REPO%"\ch\qos\logback\logback-core\1.1.11\logback-core-1.1.11.jar;"%REPO%"\org\slf4j\jcl-over-slf4j\1.7.24\jcl-over-slf4j-1.7.24.jar;"%REPO%"\org\slf4j\jul-to-slf4j\1.7.24\jul-to-slf4j-1.7.24.jar;"%REPO%"\org\slf4j\log4j-over-slf4j\1.7.24\log4j-over-slf4j-1.7.24.jar;"%REPO%"\org\yaml\snakeyaml\1.17\snakeyaml-1.17.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-tomcat\1.5.2.RELEASE\spring-boot-starter-tomcat-1.5.2.RELEASE.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-core\8.5.11\tomcat-embed-core-8.5.11.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-el\8.5.11\tomcat-embed-el-8.5.11.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-websocket\8.5.11\tomcat-embed-websocket-8.5.11.jar;"%REPO%"\org\hibernate\hibernate-validator\5.3.4.Final\hibernate-validator-5.3.4.Final.jar;"%REPO%"\javax\validation\validation-api\1.1.0.Final\validation-api-1.1.0.Final.jar;"%REPO%"\org\jboss\logging\jboss-logging\3.3.0.Final\jboss-logging-3.3.0.Final.jar;"%REPO%"\com\fasterxml\classmate\1.3.3\classmate-1.3.3.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-databind\2.8.7\jackson-databind-2.8.7.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-annotations\2.8.0\jackson-annotations-2.8.0.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-core\2.8.7\jackson-core-2.8.7.jar;"%REPO%"\org\springframework\spring-web\4.3.7.RELEASE\spring-web-4.3.7.RELEASE.jar;"%REPO%"\org\springframework\spring-aop\4.3.7.RELEASE\spring-aop-4.3.7.RELEASE.jar;"%REPO%"\org\springframework\spring-beans\4.3.7.RELEASE\spring-beans-4.3.7.RELEASE.jar;"%REPO%"\org\springframework\spring-context\4.3.7.RELEASE\spring-context-4.3.7.RELEASE.jar;"%REPO%"\org\springframework\spring-webmvc\4.3.7.RELEASE\spring-webmvc-4.3.7.RELEASE.jar;"%REPO%"\org\springframework\spring-expression\4.3.7.RELEASE\spring-expression-4.3.7.RELEASE.jar;"%REPO%"\org\apache\maven\maven-project\2.2.1\maven-project-2.2.1.jar;"%REPO%"\org\apache\maven\maven-settings\2.2.1\maven-settings-2.2.1.jar;"%REPO%"\org\apache\maven\maven-profile\2.2.1\maven-profile-2.2.1.jar;"%REPO%"\org\apache\maven\maven-model\2.2.1\maven-model-2.2.1.jar;"%REPO%"\org\apache\maven\maven-artifact-manager\2.2.1\maven-artifact-manager-2.2.1.jar;"%REPO%"\org\apache\maven\maven-repository-metadata\2.2.1\maven-repository-metadata-2.2.1.jar;"%REPO%"\org\apache\maven\wagon\wagon-provider-api\1.0-beta-6\wagon-provider-api-1.0-beta-6.jar;"%REPO%"\backport-util-concurrent\backport-util-concurrent\3.1\backport-util-concurrent-3.1.jar;"%REPO%"\org\apache\maven\maven-plugin-registry\2.2.1\maven-plugin-registry-2.2.1.jar;"%REPO%"\org\codehaus\plexus\plexus-interpolation\1.11\plexus-interpolation-1.11.jar;"%REPO%"\org\codehaus\plexus\plexus-utils\1.5.15\plexus-utils-1.5.15.jar;"%REPO%"\org\apache\maven\maven-artifact\2.2.1\maven-artifact-2.2.1.jar;"%REPO%"\org\codehaus\plexus\plexus-container-default\1.0-alpha-9-stable-1\plexus-container-default-1.0-alpha-9-stable-1.jar;"%REPO%"\classworlds\classworlds\1.1-alpha-2\classworlds-1.1-alpha-2.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-web-services\1.5.2.RELEASE\spring-boot-starter-web-services-1.5.2.RELEASE.jar;"%REPO%"\org\springframework\spring-oxm\4.3.7.RELEASE\spring-oxm-4.3.7.RELEASE.jar;"%REPO%"\org\springframework\ws\spring-ws-core\2.4.0.RELEASE\spring-ws-core-2.4.0.RELEASE.jar;"%REPO%"\org\springframework\ws\spring-xml\2.4.0.RELEASE\spring-xml-2.4.0.RELEASE.jar;"%REPO%"\org\slf4j\slf4j-api\1.7.24\slf4j-api-1.7.24.jar;"%REPO%"\junit\junit\4.12\junit-4.12.jar;"%REPO%"\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;"%REPO%"\org\springframework\spring-core\4.3.7.RELEASE\spring-core-4.3.7.RELEASE.jar;"%REPO%"\commons-codec\commons-codec\1.9\commons-codec-1.9.jar;"%REPO%"\com\google\code\gson\gson\2.2.4\gson-2.2.4.jar;"%REPO%"\com\soso\soso-services-details\0.0.2\soso-services-details-0.0.2.jar

set ENDORSED_DIR=
if NOT "%ENDORSED_DIR%" == "" set CLASSPATH="%BASEDIR%"\%ENDORSED_DIR%\*;%CLASSPATH%

if NOT "%CLASSPATH_PREFIX%" == "" set CLASSPATH=%CLASSPATH_PREFIX%;%CLASSPATH%

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS%  -classpath %CLASSPATH% -Dapp.name="webapp" -Dapp.repo="%REPO%" -Dapp.home="%BASEDIR%" -Dbasedir="%BASEDIR%" com.soso.ServicrdDetailServiceApplication %CMD_LINE_ARGS%
if %ERRORLEVEL% NEQ 0 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=%ERRORLEVEL%

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@REM If error code is set to 1 then the endlocal was done already in :error.
if %ERROR_CODE% EQU 0 @endlocal


:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
