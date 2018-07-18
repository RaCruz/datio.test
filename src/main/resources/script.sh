#!/bin/bash
echo '*****************    Downloading file   *****************'
wget --no-check-certificate https://nexus.daas-mx-dpy-01.ext.mx.iaas.igrupobbva/repository/mx-raw/processing/check-up/Sacramentorealestatetransactions.csv

echo '*****************    Number of lines    *****************'
wc -l Sacramentorealestatetransactions.csv

echo '*****************     Last 10 lines     *****************'
tail Sacramentorealestatetransactions.csv

echo '*****************     Fist 10 lines     *****************'
head Sacramentorealestatetransactions.csv

echo '*****************  Multi-Family filter  *****************'
grep -i 'Multi-family' Sacramentorealestatetransactions.csv
