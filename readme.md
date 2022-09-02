## Data Penduduk With Java Spring-Boot

aplikasi pendataan penduduk dengan fitur generate NIK(Nomor Induk Kependudukan) secara otomatis,dimana NIK tersebut Terdiri dari:

1. 2 digit pertama merupakan kode provinsi
2. 2 digit berikutnya merupakan kode kab/kota
3. 2 digit berikutnya merupakan kecamatan
4. 4 digit berikutnya merupakan nomor pendaftaran

### How To Run
```
mvn spring-boot:run
```
### Database & Table
```sql
create database db_data_penduduk;

create table if not exists province (
	id varchar(5) primary key,
	name varchar(50),
	created_at timestamp,
	updated_at timestamp
);

create table if not exists regency (
	id varchar(5) primary key,
	name varchar(50),
	province_id varchar(5),
	created_at timestamp,
	updated_at timestamp,
	foreign key (province_id) references province(id)
);

create table if not exists district (
	id varchar(5) primary key,
	name varchar(50),
	regency_id varchar(5),
	created_at timestamp,
	updated_at timestamp,
	foreign key (regency_id) references regency(id)
);

create table if not exists people (
	id varchar(5) primary key,
	nik varchar(16),
	name varchar(50),
	gender varchar(1),
	dob date,
	pob varchar(35),
	province_id varchar(5),
	regency_id varchar(5),
	district_id varchar(5),
	created_at timestamp,
	updated_at timestamp,
	foreign key (province_id) references province(id),
	foreign key (regency_id) references regency(id),
	foreign key (district_id) references district(id)
);

CREATE TABLE NIK (
	NIK varchar(5) NOT NULL
);
```

### API Spec
- Port: `8080`
#### Province
- Request: `POST`
- Endpoint: `/api/province`
- Body
```json
{
  "id": "31",
  "name": "jawa Barat"
}
```
- Response:
```json
{
  "id": "31",
  "name": "jawa Barat",
  "created_at": "2022-09-02T08:45:21.904+00:00",
  "update_at": null
}
```
- Request: `GET`
- Endpoint: `/api/province`
- Response:
```json

[
  {
    "id": "31",
    "name": "Jawa Barat",
    "created_at": "2022-09-02T08:45:21.904+00:00",
    "update_at": "2022-09-02T08:50:24.904+00:00"
  }
]

 ```
- Request: `GET`
- Endpoint: `/api/province/31`
- Response:
```json
{
  "id": "31",
  "name": "jawa barat",
  "created_at": "2022-09-02T08:45:21.904+00:00",
  "update_at": "2022-09-02T08:50:24.904+00:00"
}

 ```
- Request: `PUT`
- Endpoint: `/api/province`
- Body
```json

{
  "id": "31",
  "name": "Jawa Barat"
}

```
- Response:
```json
{
  "id": "31",
  "name": "Jawa Barat",
  "created_at": "2022-09-02T08:45:21.904+00:00",
  "update_at": "2022-09-02T08:50:24.904+00:00"
}
```

- Request: `DELETE`
- Endpoint: `/api/provinve/31`
- Response:
```
status : id 31 berhasil dihapus
 ```
#### Regency
- Request: `POST`
- Endpoint: `/api/regency`
- Body
```json
{
  "id" : "01",
  "name" : "Bandung",
  "province_id" : "31"
}
```
- Response:
```json
{
  "id": "01",
  "name": "Bandung",
  "province_id": "31",
  "province": {
    "id": "31",
    "name": "Jawa Barat",
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "created_at": "2022-09-02",
  "update_at": null
}
```
- Request: `GET`
- Endpoint: `/regency`
- Response:
```json
[
  {
    "id": "01",
    "name": "Bandung",
    "province_id": "31",
    "province": {
      "id": "31",
      "name": "Jawa Barat",
      "created_at": "2022-09-02",
      "update_at": "2022-09-02"
    },
    "created_at": "2022-09-02",
    "update_at": null
  }
]
 ```
- Request: `GET`
- Endpoint: `/api/regency/01`
- Response:
```json
{
  "id": "01",
  "name": "Bandung",
  "province_id": "31",
  "province": {
    "id": "31",
    "name": "Jawa Barat",
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "created_at": "2022-09-02",
  "update_at": null
}
 ```
- Request: `PUT`
- Endpoint: `/api/regency`
- Body
```json
{
  "id": "01",
  "name": "Kota Bandung",
  "province_id": "31"
}
```
- Response:
```json
{
  "id": "01",
  "name": "Kota Bandung",
  "province_id": "31",
  "province": {
    "id": "31",
    "name": "Jawa Barat",
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "created_at": "2022-09-02",
  "update_at": null
}
```

- Request: `DELETE`
- Endpoint: `/regency/01`
- Response:
```
status : id 01 berhasil dihapus
 ```
#### District
- Request: `POST`
- Endpoint: `/api/district`
- Body
```json
{
  "id": "01",
  "name": "Buah Batu",
  "regency_id":"01"
}
```
- Response:
```json
{
  "id": "01",
  "name": "Buah Batu",
  "regency_id": "01",
  "regency": {
    "id": "01",
    "name": "Kota Bandung",
    "province_id": null,
    "province": null,
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "created_at": "2022-09-02",
  "update_at": null
}
```
- Request: `GET`
- Endpoint: `/district`
- Response:
```json
[
  {
    "id": "01",
    "name": "Buah Batu",
    "regency_id": "01",
    "regency": {
      "id": "01",
      "name": "Kota Bandung",
      "province_id": null,
      "province": null,
      "created_at": "2022-09-02",
      "update_at": "2022-09-02"
    },
    "created_at": "2022-09-02",
    "update_at": null
  }
]
 ```
- Request: `GET`
- Endpoint: `/api/district/01`
- Response:
```json
{
  "id": "01",
  "name": "buah-batu",
  "regency_id": "01",
  "regency": {
    "id": "01",
    "name": "Kota Bandung",
    "province_id": null,
    "province": null,
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "created_at": "2022-09-02",
  "update_at": null
}
 ```
- Request: `PUT`
- Endpoint: `/district`
- Body
```json
{
  "id": "01",
  "name": "Buah Batu",
  "regency_id":"01"
}
```
- Response:
```json
{
  "id": "01",
  "name": "buah-batu",
  "regency_id": "01",
  "regency": {
    "id": "01",
    "name": "Kota Bandung",
    "province_id": null,
    "province": null,
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "created_at": "2022-09-02",
  "update_at": "2022-09-02"
}
```

- Request: `DELETE`
- Endpoint: `/district/01`
- Response:
```
status : id 01 berhasil dihapus
 ```
#### People
- Request: `POST`
- Endpoint: `/people`
- Body
```json
{
  "id": "01",
  "name": "Fikri",
  "gender": "laki-laki",
  "dob": "2000-11-07",
  "pob": "jalan",
  "province_id": "31",
  "regency_id": "01",
  "district_id": "01"
}
```
- Response:
```json
{
  "id": "01",
  "name": "Fikri",
  "nik": "31010100003",
  "gender": "laki-laki",
  "dob": "2000-11-07",
  "pob": "jalan",
  "province_id": "31",
  "regency_id": "01",
  "district_id": "01",
  "province": {
    "id": "31",
    "name": "Jawa Barat",
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "regency": {
    "id": "01",
    "name": "Kota Bandung",
    "province_id": "31",
    "province": null,
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "district": {
    "id": "01",
    "name": "buah-batu",
    "regency_id": "01",
    "regency": null,
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "created_at": "2022-09-02",
  "update_at": null
}
```
- Request: `GET`
- Endpoint: `/people`
- Response:
```json
[
  {
    "id": "01",
    "name": "Fikri",
    "nik": "31010100003",
    "gender": "laki-laki",
    "dob": "2000-11-07",
    "pob": "jalan",
    "province_id": "31",
    "regency_id": "01",
    "district_id": "01",
    "province": {
      "id": "31",
      "name": "Jawa Barat",
      "created_at": "2022-09-02",
      "update_at": "2022-09-02"
    },
    "regency": {
      "id": "01",
      "name": "Kota Bandung",
      "province_id": "31",
      "province": null,
      "created_at": "2022-09-02",
      "update_at": "2022-09-02"
    },
    "district": {
      "id": "01",
      "name": "buah-batu",
      "regency_id": "01",
      "regency": null,
      "created_at": "2022-09-02",
      "update_at": "2022-09-02"
    },
    "created_at": "2022-09-02",
    "update_at": null
  }
]
 ```
- Request: `GET`
- Endpoint: `/api/people/01`
- Response:
```json
{
  "id": "01",
  "name": "Fikri",
  "nik": "31010100003",
  "gender": "laki-laki",
  "dob": "2000-11-07",
  "pob": "jalan",
  "province_id": "31",
  "regency_id": "01",
  "district_id": "01",
  "province": {
    "id": "31",
    "name": "Jawa Barat",
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "regency": {
    "id": "01",
    "name": "Kota Bandung",
    "province_id": "31",
    "province": null,
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "district": {
    "id": "01",
    "name": "buah-batu",
    "regency_id": "01",
    "regency": null,
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "created_at": "2022-09-02",
  "update_at": null
}
 ```

- Request: `GET`
- Endpoint: `/api/people/nama/fikri`
- Response:
```json
{
  "id": "01",
  "name": "Fikri",
  "nik": "31010100003",
  "gender": "laki-laki",
  "dob": "2000-11-07",
  "pob": "jalan",
  "province_id": "31",
  "regency_id": "01",
  "district_id": "01",
  "province": {
    "id": "31",
    "name": "Jawa Barat",
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "regency": {
    "id": "01",
    "name": "Kota Bandung",
    "province_id": "31",
    "province": null,
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "district": {
    "id": "01",
    "name": "buah-batu",
    "regency_id": "01",
    "regency": null,
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
  },
  "created_at": "2022-09-02",
  "update_at": null
}
 ```
- Request: `put`
- Endpoint: `/api/people`
- Body
```json
{
    "id": "01",
    "name": "Fikri Herdian",
    "nik": "31010100003",
    "gender": "laki-laki",
    "dob": "2000-11-07",
    "pob": "jalan",
    "province_id": "31",
    "regency_id": "01",
    "district_id": "01",
    "province": {
        "id": "31",
        "name": "Jawa Barat",
        "created_at": "2022-09-02",
        "update_at": "2022-09-02"
    },
    "regency": {
        "id": "01",
        "name": "Kota Bandung",
        "province_id": "31",
        "province": null,
        "created_at": "2022-09-02",
        "update_at": "2022-09-02"
    },
    "district": {
        "id": "01",
        "name": "buah-batu",
        "regency_id": "01",
        "regency": null,
        "created_at": "2022-09-02",
        "update_at": "2022-09-02"
    },
    "created_at": "2022-09-02",
    "update_at": "2022-09-02"
}
```
- Request: `DELETE`
- Endpoint: `/api/people/01`
- Response:
```
status : id 01 berhasil dihapus
 ```
