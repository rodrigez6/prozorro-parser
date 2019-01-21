create table tender
(
  tender_id                       varchar(64) not null
    constraint tender_pk
      primary key,
  title                           varchar,
  description                     varchar,
  procuring_entity_id             varchar(256),
  value_amount                    double precision,
  value_currency                  varchar(64),
  value_added_tax_included        boolean,
  guarantee_amount                double precision,
  guarantee_currency              varchar(64),
  minimal_step_amount             double precision,
  auction_url                     varchar(1024),
  status                          varchar(64),
  minimal_step_currency           varchar(16),
  minimal_step_added_tax_included boolean,
  date                            timestamp,
  enquiry_period_start_date       timestamp,
  enquiry_period_end_date         timestamp,
  tender_period_start_date        timestamp,
  tender_period_end_date          timestamp,
  auction_period_start_date       timestamp,
  auction_period_end_date         timestamp,
  award_period_start_date         timestamp,
  award_period_end_date           timestamp
);

create table procuring_entity
(
  procuring_entity_id      varchar(256) not null
    constraint procuring_entity_pk
      primary key,
  name                     varchar,
  kind                     varchar(256),
  contact_point_email      varchar(256),
  contact_point_telephone  varchar(256),
  contact_point_fax_number varchar(256),
  contact_point_url        varchar(256),
  contact_point_name       varchar(256),
  address_street_address   varchar(256),
  address_locality         varchar(256),
  address_region           varchar(256),
  address_postal_code      varchar(256),
  address_country_name     varchar(256),
  identifier_scheme        varchar(256),
  identifier_legal_name    varchar,
  identifier_uri           varchar(256)
);

create table item
(
  item_id                         varchar(256) not null
    constraint item_pk
      primary key,
  tender_id                       varchar(256),
  description                     varchar,
  classification_scheme           varchar(256),
  classification_id               varchar(256),
  classification_description      varchar(256),
  classification_uri              varchar(256),
  unit_code                       varchar(256),
  unit_name                       varchar(256),
  quantity                        integer,
  delivery_date_start_date        timestamp,
  delivery_date_end_date          timestamp,
  delivery_address_street_address varchar(256),
  delivery_address_locality       varchar(256),
  delivery_address_region         varchar(256),
  delivery_address_country_name   varchar(256),
  delivery_location_latitude      varchar(256),
  delivery_location_longitude     varchar(256),
  delivery_location_elevation     varchar(256),
  related_lot                     varchar(256),
  delivery_address_postal_code    varchar(256),
  lot_id                          varchar(256),
  contract_id                     varchar(256),
  award_id                        varchar(256)
);

create table lot
(
  lot_id                          varchar(256) not null
    constraint lot_pk
      primary key,
  tender_id                       varchar(256),
  title                           varchar,
  description                     varchar,
  value_amount                    double precision,
  value_currency                  varchar(64),
  value_added_tax_included        boolean,
  guarantee_amount                double precision,
  guarantee_currency              varchar(64),
  date                            timestamp,
  minimal_step_amount             double precision,
  minimal_step_currency           varchar(64),
  minimal_step_added_tax_included boolean,
  auction_period_start_date       timestamp,
  auction_period_end_date         timestamp,
  auction_url                     varchar(256),
  status                          varchar(256),
  award_id                        varchar(256)
);

create table document
(
  document_id     varchar(256) not null
    constraint document_pk
      primary key,
  document_type   varchar(256),
  title           varchar,
  format          varchar(256),
  url             varchar(1024),
  date_published  timestamp,
  date_modified   timestamp,
  language        varchar(256),
  tender_id       varchar(256),
  item_id         varchar(256),
  lot_id          varchar(256),
  bid_id          varchar(256),
  complaint_id    varchar(256),
  cancellation_id varchar(256),
  contract_id     varchar(256),
  award_id        varchar(256)
);

create table feature
(
  feature_id  varchar(256) not null
    constraint feature_pk
      primary key,
  tender_id   varchar(256),
  lot_id      varchar(256),
  item_id     varchar(256),
  title       varchar,
  description varchar
);

create table feature_value
(
  feature_value_id serial not null
    constraint feature_value_pk
      primary key,
  feature_id       varchar(256),
  value            double precision,
  title            varchar(256),
  description      varchar(256)
);

create table organization
(
  organization_id          varchar(256) not null
    constraint organization_pk
      primary key,
  identifier_scheme        varchar(256),
  identifier_legal_name    varchar,
  identifier_uri           varchar(256),
  name                     varchar,
  address_street_address   varchar(256),
  address_locality         varchar(256),
  address_region           varchar(256),
  address_postal_code      varchar(256),
  address_country_name     varchar(256),
  contact_point_name       varchar(256),
  contact_point_email      varchar(256),
  contact_point_telephone  varchar(256),
  contact_point_fax_number varchar(256),
  contact_point_url        varchar(256)
);

create table bid
(
  bid_id                   varchar(256) not null
    constraint bid_pk
      primary key,
  date                     timestamp,
  status                   varchar(256),
  value_amount             double precision,
  value_currency           varchar(64),
  value_added_tax_included boolean,
  participation_url        varchar(256),
  tender_id                varchar(256)
);

create table lot_value
(
  lot_value_id             serial not null
    constraint lot_value_pk
      primary key,
  lot_id                   varchar(256),
  bid_id                   varchar(256),
  value_amount             double precision,
  value_currency           varchar(256),
  value_added_tax_included boolean,
  date                     timestamp,
  participation_url        varchar(256)
);

create table bid_parameter
(
  bid_parameter_id serial not null
    constraint bid_parameter_pk
      primary key,
  bid_id           varchar(256),
  code             varchar(64),
  value            double precision
);

create table bid_organization
(
  bid_id          varchar(256) not null,
  organization_id varchar(256) not null,
  constraint bid_organization_pk
    primary key (bid_id, organization_id)
);

create table award
(
  award_id                    varchar(256) not null
    constraint award_pk
      primary key,
  tender_id                   varchar(256),
  bid_id                      varchar(256),
  title                       varchar,
  description                 varchar,
  status                      varchar(256),
  date                        timestamp,
  value_amount                double precision,
  value_currency              varchar(256),
  value_added_tax_included    boolean,
  complaint_period_start_date timestamp,
  complaint_period_end_date   timestamp,
  contract_id                 varchar(256)
);

create table cancellation
(
  cancellation_id varchar(256) not null
    constraint cancellation_pk
      primary key,
  tender_id       varchar(256),
  lot_id          varchar(256),
  date            timestamp,
  reason          varchar,
  status          varchar(256)
);

create table complaint
(
  complaint_id         varchar(256) not null
    constraint complaint_pk
      primary key,
  tender_id            varchar(256),
  author_id            varchar(256),
  lot_id               varchar(256),
  award_id             varchar(256),
  title                varchar,
  description          varchar,
  date                 timestamp,
  date_submitted       timestamp,
  date_answered        timestamp,
  date_escalated       timestamp,
  date_cancelled       timestamp,
  date_decision        timestamp,
  status               varchar(256),
  type                 varchar(256),
  resolution           varchar,
  resolution_type      varchar(256),
  satisfied            varchar(256),
  decision             varchar,
  cancellation_reason  varchar,
  tenderer_action      varchar(256),
  tenderer_action_date timestamp
);

create table contract
(
  contract_id              varchar(256) not null
    constraint contract_pk
      primary key,
  tender_id                varchar(256),
  contract_number          varchar(64),
  title                    varchar,
  description              varchar,
  value_amount             double precision,
  value_currency           varchar(256),
  value_added_tax_included boolean,
  status                   varchar(64),
  period_start_date        timestamp,
  period_end_date          timestamp,
  date_signed              timestamp,
  date                     timestamp
);

create table tender_organization_funders
(
  organization_id varchar(256) not null,
  tender_id       varchar(256) not null,
  constraint tender_organization_funders_pk
    primary key (organization_id, tender_id)
);

create table contract_organization_suppliers
(
  organization_id varchar(256) not null,
  contract_id     varchar(256) not null,
  constraint contract_organization_suppliers_pk
    primary key (organization_id, contract_id)
);

create table award_organization
(
  organization_id varchar(256) not null,
  award_id        varchar(256) not null,
  constraint award_organization_pk
    primary key (organization_id, award_id)
);

create table question
(
  question_id     varchar(256) not null
    constraint question_pk
      primary key,
  organization_id varchar(256),
  tender_id       varchar(256),
  item_id         varchar(256),
  lot_id          varchar(256),
  title           varchar,
  description     varchar,
  date            timestamp,
  date_answered   timestamp,
  answer          varchar
);

create table revision
(
  revision_id varchar(256) not null
    constraint revision_pk
      primary key,
  tender_id   varchar(256),
  date        timestamp
);

create table revision_change
(
  revision_change_id serial not null
    constraint revision_change_pk
      primary key,
  revision_id        varchar(256),
  description        varchar
);


