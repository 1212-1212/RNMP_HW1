Предуслови за работа на домашната задача 1:

- инсталиран git
- инсталирани docker и docker-compose
- инсталиран python (верзија 3).

За да ја подготвите околината потребно е да ги извршите следните наредби во терминал:

1. git clone https://github.com/stefanandonov/RNMP_homework1.git
2. cd RNMP_homework1
3. chmod +x start.sh
4. ./start.sh (извршување на shell скриптата start.sh)

Со извршените команди се креира едноставен Apache Kafka кластер и се стартува python скрипта која праќа пораки на topic sensors. Ова е потребно со цел да се симулира поток на податоци. Секој податок испратен на потокот е во следниот формат:

{"key": "B", "value": 370, "timestamp": 1669748895562}

каде што timestamp го претставува epoch времето кога податокот е произведен во милисекунди.

Главна задача:

Да се развие Apache Flink апликација која ќе ги процесира податоците од податочен извор Apache Kafka topic sensors, а резултатите од процесирањата ќе се запишат на други Apache Kafka topic results1 и results2.

1. За секој клуч (key) потребно е да направи групирање на влезните пораки со непреклопувачки или преклопувачки прозорец со големина X ms и лизгање Y ms. На topic-от results1 потребно е да се испрати бројот на примени пораки во рамки на временските прозорци за секој клуч. Форматот може да го дефинирате сами.

2. За секој клуч (key) потребно е да направи групирање на влезните пораки со непреклопувачки или преклопувачки прозорец со големина X ms и лизгање Y ms. На topic-от results2 потребно е да се испратат агрегирани информации за секоја група на податоци (добиена со временските прозорци) во следниот формат:
   {"key":"B","window_start":1669748895000,"window_end":1669748896000,"min_value":10,"count":10,"average":55.55,"max_value":100}

Прикачете zip фајл во кој ќе се наоѓа изворниот код на апликацијата со кратка документација во pdf.

Материјали:

https://nightlies.apache.org/flink/flink-docs-release-1.14//docs/try-flink/local_installation/

https://nightlies.apache.org/flink/flink-docs-release-1.14/docs/dev/datastream/overview/

https://nightlies.apache.org/flink/flink-docs-release-1.14/docs/learn-flink/datastream_api/

https://nightlies.apache.org/flink/flink-docs-release-1.14/docs/dev/datastream/operators/overview/

