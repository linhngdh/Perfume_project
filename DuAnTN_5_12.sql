drop database DuAnTN
create database DuAnTN
go
use DuAnTN
go

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Photo] [nvarchar](50) NULL,
	[SDT] [nvarchar](20)  Null,
	[DiaChi] [nvarchar](max)NULL,
 CONSTRAINT [PK_Customers] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Authorities](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[RoleId] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_UserRoles] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
CREATE TABLE [dbo].[Roles](
	[Id] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [FK_UserRoles_Roles] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Roles] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [FK_UserRoles_Roles]
GO
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [FK_UserRoles_Users] FOREIGN KEY([Username])
REFERENCES [dbo].[Accounts] ([Username])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [FK_UserRoles_Users]
GO



/****** Object:  Table [dbo].[OrderDetails]    Script Date: 4/12/2021 3:07:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[OrderId] [bigint] NOT NULL,
	[Product_Id] [int] NOT NULL,
	[Price] [float] NOT NULL,
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_OrderDetails] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Orders]    Script Date: 4/12/2021 3:07:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Username_id] [nvarchar](50) NOT NULL,
	[Money] [float] NULL,
	[CreateDate] [datetime] NOT NULL,
	[Address] [nvarchar](100) NOT NULL,
	[Status] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
Go

CREATE TABLE [dbo].[Products](
	[product_id] [int] IDENTITY(1,1) NOT NULL,
	[product_name] [nvarchar](50) NOT NULL,
	[describe] [nvarchar](255) NOT NULL,	-- mô tả

	[image] [nvarchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[capacity] [float] NULL,		-- dung tích ml 
	[trademark_id] [int] NOT NULL,
	[Categories_id] [int] NOT NULL,
	[CreateDate] [date] NOT NULL,

 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE photos (
    photo_id INT PRIMARY KEY,
    product_id INT,
    photo_url VARCHAR(255)
);
GO
CREATE TABLE Brand(
	ID int IDENTITY(1,1) primary key  not null,
	Trademark nvarchar(50)  not null,
	Country varchar(50) not null,
	Note nvarchar(max),
	Photo varchar(255),
)

GO

CREATE TABLE Category (
	id INT IDENTITY(1,1) PRIMARY KEY not null,
	name NVARCHAR(50)
);

GO
SET ANSI_PADDING OFF
GO

INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [Photo], [SDT], [DiaChi]) VALUES (N'linh', N'123456', N'Linh', N'linh@gmail.com', N'user.png',null,null)
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [Photo], [SDT], [DiaChi]) VALUES (N'tai', N'123456', N'Linh123', N'linh123@gmail.com', N'user.png',null,null)
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [Photo], [SDT], [DiaChi]) VALUES (N'tuan', N'123456', N'tuan', N'tuan@gmail.com', N'user.png',null,null)
go

INSERT INTO photos (photo_id, product_id, photo_url) VALUES
  (1, 1, '1.jpg'),
  (2, 1, '2.jpg'),
  (3, 1, '3.jpg'),
  (4, 1, '4.jpg'),
  (5, 1, '5.jpg'),
  (6, 2, '5.jpg'),
  (7, 2, '5.jpg'),
  (8, 2, '5.jpg'),
  (9, 3, '5.jpg'),
  (10, 3, '5.jpg'),
  (11, 3, '6.jpg');


go

SET IDENTITY_INSERT [dbo].[Brand] ON 

INSERT [dbo].[Brand] ([ID], [Trademark], [Country], [Note], [Photo]) 
VALUES 
(1,'BVLGARI','Italia', N'Sản phẩm có mùi hương cuống hút','th_10.jpg'),
(2,'Calvin Klein','USA',N'Sản phẩm được pha chế rất công thu cho ra mùi hương dịu nhẹ','th_11.jpg'),
(3,'CAROLINA HERRERA','Venezuela và USA',N'Sản phẩm có xuất sứ từ hai nước Venezueka và hoa kỳ cho ra một loại nước hoa rất thơm','th_12.png'),
(4,'CHANEL','France',N'Sản phẩm đang có rất nhiều lượt tương tác vì sản phẩm có mùi hương rất ngọt ngào','th_13.jpg'),
(5,N'Chloẻ','France',N'Sản phẩm của Pháp mang lại cho người dùng sự tự tin lôi cuống','th_14.png'),
(6,'Dior','France',N'Sản phẩm này cũng kha khá nổi tiếng tương tự Chanel tuy nhiên sản phẩm có mùi hương khác nhau tùy vào sở thích','th_15.png'),
(7,'DAVIDOFF','Switzerland',N'Sản phẩm có một mùi hương rất cá tính đem đến cho người dùng sự trải nghiệm mới','th_18.png'),
(8,'DKNY','USA',N'Sản phẩm được sản xuất từ mỹ có mùi hương ngọt dễ chịu','th_20.gif'),
(9,'D&G','Italia',N'Sản phẩm có nguồn góc từ Ý rất hấp dẫn','th_21.jpg'),
(10,'Elizabeth Arden','USA',N'Sản phẩm nước hoa mùi hương dịu nhẹ phù hợp với tất cả mọi người','th_24.jpg')
go
SET IDENTITY_INSERT [dbo].[Brand] OFF
go

SET IDENTITY_INSERT [dbo].[Category] ON 
INSERT [dbo].[Category]([id],[name])
VALUES 
(1,N'Nước hoa nam'),
(2,N'Nước hao nữ'),
(3,N'Nước Hoa chiết'),
(4,N'Nước Hoa Xịn'),
(5,N'Nước Hoa Bình Thường')
go
SET IDENTITY_INSERT [dbo].[Category] Off

go

SET IDENTITY_INSERT [dbo].[OrderDetails] ON 
INSERT [dbo].[OrderDetails] ([Id], [OrderId], [Product_Id], [Price], [Quantity]) VALUES (100005, 100005, 1, 42.4, 40)
INSERT [dbo].[OrderDetails] ([Id], [OrderId], [Product_Id], [Price], [Quantity]) VALUES (100006, 100006, 1, 7.7, 10)
INSERT [dbo].[OrderDetails] ([Id], [OrderId], [Product_Id], [Price], [Quantity]) VALUES (100007, 100007, 1, 42.4, 35)

SET IDENTITY_INSERT [dbo].[OrderDetails] OFF
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([Id], [Username_id], [Money], [CreateDate], [Address], [Status]) VALUES (100005, N'tuan',null , CAST(0x000089B100000000 AS DateTime), N'Luisenstr. 48', N'Đã thanh toán')
INSERT [dbo].[Orders] ([Id], [Username_id], [Money], [CreateDate], [Address], [Status]) VALUES (100006, N'linh',null ,CAST(0x000089B400000000 AS DateTime), N'Rua do Paço, 67', N'Đã thanh toán')
INSERT [dbo].[Orders] ([Id], [Username_id], [Money], [CreateDate], [Address], [Status]) VALUES (100007, N'tuan',null ,CAST(0x000089B400000000 AS DateTime), N'2, rue du Commerce', N'Đã thanh toán')
INSERT [dbo].[Orders] ([Id], [Username_id], [Money], [CreateDate], [Address], [Status]) VALUES (10008, N'tuan',null ,CAST(0x000089B400000000 AS DateTime), N'2, rue du Commerce', N'Đã thanh toán')
INSERT [dbo].[Orders] ([Id], [Username_id], [Money], [CreateDate], [Address], [Status]) VALUES (10009, N'tuan',null ,CAST(0x000089B400000000 AS DateTime), N'2, rue du Commerce', N'Đã thanh toán')

SET IDENTITY_INSERT [dbo].[Orders] OFF

go
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'CUST', N'Customers')
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'DIRE', N'Directors')
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'STAF', N'Staffs')

go

SET IDENTITY_INSERT [dbo].[Authorities] ON

INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (2, N'tai', N'STAF')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (3, N'tuan', N'DIRE')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (4, N'linh', N'CUST')

SET IDENTITY_INSERT [dbo].[Authorities] OFF
go
SET IDENTITY_INSERT [dbo].[Products] ON

INSERT INTO [dbo].[Products] ([product_id], [product_name], [describe], [image], [price],[capacity], [trademark_id], [Categories_id], [CreateDate])
VALUES
    (1, N'Eau de Blossom 1', N'Eau de Blossom Mô Tả', '1.jpg', 98622.000,5,1,1, CAST(0x910D0B00 AS Date)),
	(2, N'Eau de Blossom 2', N'Eau de Blossom Mô Tả', '2.jpg', 222224.000,10,2,2, CAST(0x910D0B00 AS Date)),
	(3, N'Eau de Blossom 3', N'Eau de Blossom Mô Tả', '3.jpg', 16845.000,15,3,3, CAST(0x910D0B00 AS Date)),
	(4, N'Eau de Blossom 4', N'Eau de Blossom Mô Tả', '4.jpg', 329887.000,30,4,4, CAST(0x910D0B00 AS Date)),
	(5, N'Eau de Blossom 5', N'Eau de Blossom Mô Tả', '5.jpg', 15978.000,50,5,5, CAST(0x910D0B00 AS Date)),
	(6, N'Eau de Blossom 6', N'Eau de Blossom Mô Tả', '6.jpg', 88955.000,75,6,1, CAST(0x910D0B00 AS Date)),
	(7, N'Eau de Blossom 7', N'Eau de Blossom Mô Tả', '7.jpg', 88896.000,90,7,2, CAST(0x910D0B00 AS Date)),
	(8, N'Eau de Blossom 8', N'Eau de Blossom Mô Tả', '8.jpg', 5555.000,100,8,3, CAST(0x910D0B00 AS Date)),
	(9, N'Eau de Blossom 9', N'Eau de Blossom Mô Tả', '9.jpg', 5457.000,5,9,4, CAST(0x910D0B00 AS Date)),
	(10, N'Eau de Blossom 10', N'Eau de Blossom Mô Tả', '10.jpg', 65656.000,50,10,5, CAST(0x910D0B00 AS Date))

SET IDENTITY_INSERT [dbo].[Products] OFF

GO
---
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Orders] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Orders]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Products] FOREIGN KEY([Product_Id])
REFERENCES [dbo].[Products] (product_id)
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Products]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Customers] FOREIGN KEY([Username_id])
REFERENCES [dbo].[Accounts] ([Username])
ON UPDATE CASCADE
ON DELETE CASCADE
------
ALTER TABLE Orders
ADD CONSTRAINT DF_Orders_Status DEFAULT 'Chờ xác nhận' FOR Status;

ALTER TABLE Products ADD CONSTRAINT FK_Products_Brand FOREIGN KEY ([trademark_id]) REFERENCES Brand (ID)
ALTER TABLE Products ADD CONSTRAINT FK_Products_Category FOREIGN KEY ([Categories_id]) REFERENCES Category (id)
ALTER TABLE photos ADD CONSTRAINT FK_Products_Photos FOREIGN KEY (product_id) REFERENCES Products([product_id])




