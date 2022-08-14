#!/bin/sh
docker-compose up -d

container=mssql-server
password=mssql1Ipw
mssqlcmd=/opt/mssql-tools/bin/sqlcmd

sudo docker exec -it $container $mssqlcmd \
   -S localhost -U SA -P $password \
   -Q 'ALTER LOGIN SA WITH PASSWORD="mssql1Ipw"'

sudo docker exec -it $container mkdir /var/opt/mssql/backup
sudo docker cp db/wwi.bak $container:/var/opt/mssql/backup

sudo docker exec -it $container $mssqlcmd -S localhost \
   -U SA -P $password \
   -Q 'RESTORE FILELISTONLY FROM DISK = "/var/opt/mssql/backup/wwi.bak"' \
   | tr -s ' ' | cut -d ' ' -f 1-2

sudo docker exec -it $container $mssqlcmd \
   -S localhost -U SA -P $password \
   -Q 'RESTORE DATABASE WideWorldImporters FROM DISK = "/var/opt/mssql/backup/wwi.bak" WITH MOVE "WWI_Primary" TO "/var/opt/mssql/data/WideWorldImporters.mdf", MOVE "WWI_UserData" TO "/var/opt/mssql/data/WideWorldImporters_userdata.ndf", MOVE "WWI_Log" TO "/var/opt/mssql/data/WideWorldImporters.ldf", MOVE "WWI_InMemory_Data_1" TO "/var/opt/mssql/data/WideWorldImporters_InMemory_Data_1"'
