CREATE TYPE "user_role" AS ENUM (
  'comprador',
  'vendedor'
);

CREATE TYPE "product_status" AS ENUM (
  'in_stock',
  'out_of_stock',
  'running_low'
);

CREATE TYPE "payment_methods" AS ENUM (
  'paypal',
  'credit_card',
  'oxxo'
);

CREATE TYPE "status_order" AS ENUM (
  'Pendiente',
  'Proceso',
  'Confirmado',
  'Entregado',
  'Retrasado',
  'Cancelado'
);

CREATE TABLE "users" (
  "id_user" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "first_name" varchar(100) NOT NULL,
  "middle_name" varchar(100),
  "last_name" varchar(100) NOT NULL,
  "second_last_name" varchar(100) NOT NULL,
  "email" varchar(255) UNIQUE NOT NULL,
  "password" varchar(255),
  "role" user_role,
  "phone" integer(10),
  "avatar" varchar(1000),
  "created_at" timestamp DEFAULT 'now()',
  "fk_id_shopping_cart" int,
  "fk_id_address" int
);

CREATE TABLE "profile_maker" (
  "id_profile_maker" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "name_profile" varchar(200) NOT NULL,
  "description" varchar(500) NOT NULL,
  "created_at" timestamp DEFAULT 'now()',
  "fk_id_user" int
);

CREATE TABLE "products" (
  "id_product" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "name_product" varchar(200) NOT NULL,
  "description" varchar(500) NOT NULL,
  "serial" varchar UNIQUE NOT NULL,
  "status" product_status NOT NULL,
  "stock" int NOT NULL,
  "price" DECIMAL(8,2) NOT NULL,
  "created_at" timestamp DEFAULT 'now()',
  "fk_id_profile_maker" int
);

CREATE TABLE "category" (
  "id_category" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "name_category" varchar(150) UNIQUE NOT NULL,
  "fk_id_product" int
);

CREATE TABLE "sub_category" (
  "id_sub_category" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "name_category" varchar(150) UNIQUE NOT NULL,
  "fk_id_category" integer
);

CREATE TABLE "shopping_cart" (
  "id_shopping_cart" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "subtotal" DECIMAL(8,2) NOT NULL,
  "fk_id_user" int,
  "fk_id_product" int,
  "created_at" timestamp DEFAULT 'now()'
);

CREATE TABLE "addresses" (
  "id_address" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "full_name" varchar(300) NOT NULL,
  "phone" int(10) NOT NULL,
  "country" varchar(100) NOT NULL,
  "postal_code" varchar(10) NOT NULL,
  "estate" varchar(100) NOT NULL,
  "city" varchar(100) NOT NULL,
  "street" varchar(100) NOT NULL,
  "references" varchar(200) NOT NULL,
  "created_at" timestamp DEFAULT 'now()'
);

CREATE TABLE "comments" (
  "id_comment" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "description" varchar(500) NOT NULL,
  "img" varchar(1000),
  "fk_id_user" int,
  "fk_id_profile_maker" int
);

CREATE TABLE "reviews" (
  "id_review" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "description" varchar(500) NOT NULL,
  "img" varchar(1000),
  "fk_id_user" int,
  "fk_id_product" int
);

CREATE TABLE "orden_details" (
  "id_orden_detail" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "payment_method" payment_methods,
  "order_status" status_order,
  "fk_id_user" int,
  "fk_id_products" int,
  "fk_id_address" int,
  "monto_total" DECIMAL(8,2) NOT NULL
);

ALTER TABLE "orden_details" ADD FOREIGN KEY ("fk_id_user") REFERENCES "users" ("id_user");

CREATE TABLE "products_orden_details" (
  "products_id_product" int,
  "orden_details_fk_id_products" int,
  PRIMARY KEY ("products_id_product", "orden_details_fk_id_products")
);

ALTER TABLE "products_orden_details" ADD FOREIGN KEY ("products_id_product") REFERENCES "products" ("id_product");

ALTER TABLE "products_orden_details" ADD FOREIGN KEY ("orden_details_fk_id_products") REFERENCES "orden_details" ("fk_id_products");


ALTER TABLE "orden_details" ADD FOREIGN KEY ("fk_id_address") REFERENCES "addresses" ("id_address");

ALTER TABLE "comments" ADD FOREIGN KEY ("fk_id_user") REFERENCES "users" ("id_user");

ALTER TABLE "comments" ADD FOREIGN KEY ("fk_id_profile_maker") REFERENCES "profile_maker" ("id_profile_maker");

ALTER TABLE "reviews" ADD FOREIGN KEY ("id_review") REFERENCES "products" ("id_product");

ALTER TABLE "reviews" ADD FOREIGN KEY ("fk_id_user") REFERENCES "users" ("id_user");

ALTER TABLE "addresses" ADD FOREIGN KEY ("id_address") REFERENCES "users" ("id_user");

CREATE TABLE "products_shopping_cart" (
  "products_id_product" int,
  "shopping_cart_fk_id_user" int,
  PRIMARY KEY ("products_id_product", "shopping_cart_fk_id_user")
);

ALTER TABLE "products_shopping_cart" ADD FOREIGN KEY ("products_id_product") REFERENCES "products" ("id_product");

ALTER TABLE "products_shopping_cart" ADD FOREIGN KEY ("shopping_cart_fk_id_user") REFERENCES "shopping_cart" ("fk_id_user");


ALTER TABLE "shopping_cart" ADD FOREIGN KEY ("fk_id_user") REFERENCES "users" ("fk_id_shopping_cart");

ALTER TABLE "products" ADD FOREIGN KEY ("fk_id_profile_maker") REFERENCES "profile_maker" ("id_profile_maker");

ALTER TABLE "category" ADD FOREIGN KEY ("fk_id_product") REFERENCES "products" ("id_product");

ALTER TABLE "profile_maker" ADD FOREIGN KEY ("fk_id_user") REFERENCES "users" ("id_user");

ALTER TABLE "sub_category" ADD FOREIGN KEY ("fk_id_category") REFERENCES "category" ("id_category");