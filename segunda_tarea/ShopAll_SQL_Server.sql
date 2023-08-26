CREATE TABLE [users] (
  [id_user] int PRIMARY KEY IDENTITY(1, 1),
  [first_name] varchar(100) NOT NULL,
  [middle_name] varchar(100),
  [last_name] varchar(100) NOT NULL,
  [second_last_name] varchar(100) NOT NULL,
  [email] varchar(255) UNIQUE NOT NULL,
  [password] varchar(255),
  [role] nvarchar(255) NOT NULL CHECK ([role] IN ('comprador', 'vendedor')),
  [phone] integer(10),
  [avatar] varchar(1000),
  [created_at] timestamp DEFAULT 'now()',
  [fk_id_shopping_cart] int,
  [fk_id_address] int
)
GO

CREATE TABLE [profile_maker] (
  [id_profile_maker] int PRIMARY KEY IDENTITY(1, 1),
  [name_profile] varchar(200) NOT NULL,
  [description] varchar(500) NOT NULL,
  [created_at] timestamp DEFAULT 'now()',
  [fk_id_user] int
)
GO

CREATE TABLE [products] (
  [id_product] int PRIMARY KEY IDENTITY(1, 1),
  [name_product] varchar(200) NOT NULL,
  [description] varchar(500) NOT NULL,
  [serial] nvarchar(255) UNIQUE NOT NULL,
  [status] nvarchar(255) NOT NULL CHECK ([status] IN ('in_stock', 'out_of_stock', 'running_low')) NOT NULL,
  [stock] int NOT NULL,
  [price] DECIMAL(8,2) NOT NULL,
  [created_at] timestamp DEFAULT 'now()',
  [fk_id_profile_maker] int
)
GO

CREATE TABLE [category] (
  [id_category] int PRIMARY KEY IDENTITY(1, 1),
  [name_category] varchar(150) UNIQUE NOT NULL,
  [fk_id_product] int
)
GO

CREATE TABLE [sub_category] (
  [id_sub_category] int PRIMARY KEY IDENTITY(1, 1),
  [name_category] varchar(150) UNIQUE NOT NULL,
  [fk_id_category] integer
)
GO

CREATE TABLE [shopping_cart] (
  [id_shopping_cart] int PRIMARY KEY IDENTITY(1, 1),
  [subtotal] DECIMAL(8,2) NOT NULL,
  [fk_id_user] int,
  [fk_id_product] int,
  [created_at] timestamp DEFAULT 'now()'
)
GO

CREATE TABLE [addresses] (
  [id_address] int PRIMARY KEY IDENTITY(1, 1),
  [full_name] varchar(300) NOT NULL,
  [phone] int(10) NOT NULL,
  [country] varchar(100) NOT NULL,
  [postal_code] varchar(10) NOT NULL,
  [estate] varchar(100) NOT NULL,
  [city] varchar(100) NOT NULL,
  [street] varchar(100) NOT NULL,
  [references] varchar(200) NOT NULL,
  [created_at] timestamp DEFAULT 'now()'
)
GO

CREATE TABLE [comments] (
  [id_comment] int PRIMARY KEY IDENTITY(1, 1),
  [description] varchar(500) NOT NULL,
  [img] varchar(1000),
  [fk_id_user] int,
  [fk_id_profile_maker] int
)
GO

CREATE TABLE [reviews] (
  [id_review] int PRIMARY KEY IDENTITY(1, 1),
  [description] varchar(500) NOT NULL,
  [img] varchar(1000),
  [fk_id_user] int,
  [fk_id_product] int
)
GO

CREATE TABLE [orden_details] (
  [id_orden_detail] int PRIMARY KEY IDENTITY(1, 1),
  [payment_method] nvarchar(255) NOT NULL CHECK ([payment_method] IN ('paypal', 'credit_card', 'oxxo')),
  [order_status] nvarchar(255) NOT NULL CHECK ([order_status] IN ('Pendiente', 'Proceso', 'Confirmado', 'Entregado', 'Retrasado', 'Cancelado')),
  [fk_id_user] int,
  [fk_id_products] int,
  [fk_id_address] int,
  [monto_total] DECIMAL(8,2) NOT NULL
)
GO

ALTER TABLE [orden_details] ADD FOREIGN KEY ([fk_id_user]) REFERENCES [users] ([id_user])
GO

CREATE TABLE [products_orden_details] (
  [products_id_product] int,
  [orden_details_fk_id_products] int,
  PRIMARY KEY ([products_id_product], [orden_details_fk_id_products])
);
GO

ALTER TABLE [products_orden_details] ADD FOREIGN KEY ([products_id_product]) REFERENCES [products] ([id_product]);
GO

ALTER TABLE [products_orden_details] ADD FOREIGN KEY ([orden_details_fk_id_products]) REFERENCES [orden_details] ([fk_id_products]);
GO


ALTER TABLE [orden_details] ADD FOREIGN KEY ([fk_id_address]) REFERENCES [addresses] ([id_address])
GO

ALTER TABLE [comments] ADD FOREIGN KEY ([fk_id_user]) REFERENCES [users] ([id_user])
GO

ALTER TABLE [comments] ADD FOREIGN KEY ([fk_id_profile_maker]) REFERENCES [profile_maker] ([id_profile_maker])
GO

ALTER TABLE [reviews] ADD FOREIGN KEY ([id_review]) REFERENCES [products] ([id_product])
GO

ALTER TABLE [reviews] ADD FOREIGN KEY ([fk_id_user]) REFERENCES [users] ([id_user])
GO

ALTER TABLE [addresses] ADD FOREIGN KEY ([id_address]) REFERENCES [users] ([id_user])
GO

CREATE TABLE [products_shopping_cart] (
  [products_id_product] int,
  [shopping_cart_fk_id_user] int,
  PRIMARY KEY ([products_id_product], [shopping_cart_fk_id_user])
);
GO

ALTER TABLE [products_shopping_cart] ADD FOREIGN KEY ([products_id_product]) REFERENCES [products] ([id_product]);
GO

ALTER TABLE [products_shopping_cart] ADD FOREIGN KEY ([shopping_cart_fk_id_user]) REFERENCES [shopping_cart] ([fk_id_user]);
GO


ALTER TABLE [shopping_cart] ADD FOREIGN KEY ([fk_id_user]) REFERENCES [users] ([fk_id_shopping_cart])
GO

ALTER TABLE [products] ADD FOREIGN KEY ([fk_id_profile_maker]) REFERENCES [profile_maker] ([id_profile_maker])
GO

ALTER TABLE [category] ADD FOREIGN KEY ([fk_id_product]) REFERENCES [products] ([id_product])
GO

ALTER TABLE [profile_maker] ADD FOREIGN KEY ([fk_id_user]) REFERENCES [users] ([id_user])
GO

ALTER TABLE [sub_category] ADD FOREIGN KEY ([fk_id_category]) REFERENCES [category] ([id_category])
GO
