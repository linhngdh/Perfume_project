drop database DuAnTN
create database DuAnTN
go
use DuAnTN
go

GO
CREATE TABLE [dbo].[Accounts](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Photo] [nvarchar](50) NOT NULL,
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
GO
-- Bảng Sản phẩm (Products)
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    product_name NVARCHAR(50),
	trademark NVARCHAR(50),
    description NVARCHAR(250),
	image NVARCHAR(50),
    price DECIMAL(10, 2),
);
GO
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [Photo]) VALUES (N'linh', N'123456', N'Linh', N'linh@gmail.com', N'user.png')
go
INSERT INTO Products (product_id, product_name, trademark, description, image, price)
VALUES
    (1, 'Eau de Blossom', 'FloralFragrance', 'Eau de Blossom is a delicate floral fragrance with notes of jasmine and rose. It evokes the freshness of a spring morning.', '1.jpg', 500.000),
    (2, 'Amber Mystique', 'LuxuryScents', 'Amber Mystique is a luxurious oriental fragrance with warm amber, vanilla, and sandalwood. Perfect for elegant evenings.', '2.jpg', 650.000),
    (3, 'Citrus Zest', 'SunshinePerfumes', 'Citrus Zest captures the essence of sunny days with its blend of lemon, bergamot, and orange blossom. A refreshing choice.', '3.jpg', 700.000),
    (4, 'Midnight Velvet', 'NocturnalFragrance', 'Midnight Velvet is a mysterious and sensual fragrance featuring notes of black orchid, vanilla, and musk.', '4.jpg', 750.000),
    (5, 'Ocean Breeze', 'SeasideScents', 'Ocean Breeze brings the salty freshness of the sea with marine accords, sea salt, and driftwood. Ideal for beach lovers.', '5.jpg', 800.000),
    (6, 'Silk Serenade', 'ElegancePerfumes', 'Silk Serenade is an elegant blend of white florals and silkwood. It exudes sophistication and grace.', '6.jpg', 850.000),
    (7, 'Velvet Rose', 'RomanticFragrance', 'Velvet Rose envelops you in the rich scent of velvety red roses. Passionate and timeless.', '7.jpg', 900.000),
    (8, 'Golden Oud', 'ExoticScents', 'Golden Oud combines precious oud wood with saffron and spices. A luxurious choice for special occasions.', '8.jpg', 950.000),
    (9, 'Blossom Dreams', 'DreamyFragrance', 'Blossom Dreams is a dreamy blend of cherry blossoms, peony, and soft musk. Perfect for daydreamers.', '9.jpg', 490.000),
    (10, 'Mystic Amber', 'EnchantingAromas', 'Mystic Amber weaves together ambergris, incense, and patchouli for an enchanting and mystical experience.', '10.jpg', 450.000)


	go
-- Bảng Đơn hàng (Orders)
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    user_id INT REFERENCES Users(user_id),
    order_date DATE
);
go
insert into Orders
values  (1, 101, '2023-10-01'),
		(2, 102, '2023-10-02'),
		(3, 103, '2023-10-03'),
		(4, 104, '2023-10-04'),
		(5, 105, '2023-10-05')
		go
CREATE TABLE Orders_Detail (
    Order_Id INT,
    Product_Id INT,
    Quantity INT,
    FOREIGN KEY (Order_Id) REFERENCES Orders (order_id),
    FOREIGN KEY (Product_Id) REFERENCES Products (product_id)
);

go
INSERT INTO Orders_Detail VALUES
    (1, 1, 1),
    (2, 3, 3),
    (3, 2, 2),
    (4, 4, 1),
    (5, 5, 4)

	go
-- Bảng Đánh giá (Reviews)
CREATE TABLE Reviews (
    review_id INT PRIMARY KEY,
    product_id INT REFERENCES Products(product_id),
    user_id INT REFERENCES Users(user_id),
    rating INT,
    comment TEXT
);
go
INSERT INTO Reviews (review_id, product_id, user_id, rating, comment)
VALUES
    (1, 1, 101, 5, 'Sản phẩm tuyệt vời!'),
    (2, 2, 102, 4, 'Tôi rất hài lòng với sản phẩm này.'),
    (3, 3, 103, 3, 'Không tệ, nhưng cũng không tốt lắm.'),
    (4, 4, 104, 5, 'Tôi thích sản phẩm này.'),
    (5, 5, 105, 2, 'Tôi không hài lòng với chất lượng.')
	go
-- Bảng Giỏ hàng (Carts)
CREATE TABLE Carts (
    user_id INT REFERENCES Users(user_id),
	product_id INT,
	quantity INT,
	payment VARCHAR(50)
);
go
INSERT INTO Carts (user_id, product_id, quantity, payment) VALUES
    (101, 1, 2, 'Credit Card'),
    (102, 3, 1, 'PayPal'),
    (103, 2, 4, 'Credit Card'),
    (104, 4, 3, 'Cash On Delivery'),
    (105, 5, 2, 'Credit Card')
	go
-- Bảng Thanh toán (Payments)
CREATE TABLE Payments (
    payment_id INT PRIMARY KEY,
    order_id INT REFERENCES Orders(order_id),
	user_id INT REFERENCES Users(user_id),
	payment_method VARCHAR(50),
	expiration_date DATE,
	tag_name VARCHAR(50)
);
go
INSERT INTO Payments (payment_id, order_id, user_id, payment_method, expiration_date, tag_name)
VALUES
    (1, 1, 101, 'Credit Card', '2023-12-31', 'Payment Tag A'),
    (2, 2, 102, 'PayPal', '2023-11-30', 'Payment Tag B'),
    (3, 3, 103, 'Credit Card', '2023-10-31', 'Payment Tag C'),
    (4, 4, 104, 'Cash On Delivery', '2023-09-30', 'Payment Tag D'),
    (5, 5, 105, 'Credit Card', '2023-08-31', 'Payment Tag E')
	go
-- Bảng Khuyến mãi (Promotions)
CREATE TABLE Promotions (
    promotion_id INT PRIMARY KEY,
    promotion_name VARCHAR(255),
    start_date DATE,
    end_date DATE
);
go
INSERT INTO Promotions (promotion_id, promotion_name, start_date, end_date)
VALUES
    (1, 'Summer Sale', '2023-06-01', '2023-06-30'),
    (2, 'Back to School', '2023-08-01', '2023-08-31'),
    (3, 'Holiday Season', '2023-11-01', '2023-12-31'),
    (4, 'Black Friday', '2023-11-25', '2023-11-27'),
    (5, 'New Year Clearance', '2023-12-31', '2024-01-15')
select * from Users
	go
-- Bảng Vận chuyển (Shipping)
/*CREATE TABLE Shipping (
    shipping_id INT PRIMARY KEY,
    order_id INT REFERENCES Orders(order_id),
    shipping_address VARCHAR(255)
);

-- Bảng Danh mục (Categories)
CREATE TABLE Categories (
    category_id INT PRIMARY KEY,
    category_name VARCHAR(255),
    parent_category_id INT REFERENCES Categories(category_id)
);

-- Bảng Lịch sử hoạt động (Activity Log)
/*CREATE TABLE ActivityLog (
    log_id INT PRIMARY KEY,
    user_id INT REFERENCES Users(user_id),
    activity_type VARCHAR(50),
    activity_date DATETIME
);

