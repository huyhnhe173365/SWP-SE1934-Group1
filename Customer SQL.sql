CREATE DATABASE IF NOT EXISTS CustomerDB;
USE CustomerDB;

CREATE TABLE Customers (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    PhoneNumber VARCHAR(10),
    CitizenID INT NULL,
    DateOfBirth DATE NULL,
    CustomerType VARCHAR(50),
    PasswordHash VARCHAR(250) NOT NULL,
    IsEmailConfirmed BIT NOT NULL,
    IsDeleted BIT NOT NULL,
    RoleID INT NOT NULL,
    
    CONSTRAINT fk_customer_role FOREIGN KEY (RoleID) REFERENCES Roles(ID)
);
CREATE TABLE Roles (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    RoleName VARCHAR(100) NOT NULL
);

CREATE TABLE EmailConfirmed (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    Token NVARCHAR(255) NOT NULL,
    ExpirationDate DATETIME NOT NULL,

    CONSTRAINT fk_email_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID)
);

CREATE TABLE Labels (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    LabelName VARCHAR(100) NOT NULL UNIQUE,
    Description TEXT,
    ContactInfo VARCHAR(250),
    Status ENUM('Active', 'Inactive') DEFAULT 'Active'
);

CREATE TABLE Storages (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    StorageName VARCHAR(100) NOT NULL,
    Address VARCHAR(250) NOT NULL,
    Capacity INT,
    PricePerMonth DECIMAL(10, 2),
    ContactInfo VARCHAR(250),
    Status ENUM('Available', 'Occupied', 'Maintenance') DEFAULT 'Available'
);

CREATE TABLE Vouchers (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Code VARCHAR(50) NOT NULL UNIQUE,
    Description TEXT,
    DiscountType ENUM('Percentage', 'Fixed') NOT NULL,
    DiscountValue DECIMAL(10, 2) NOT NULL,
    MinOrderAmount DECIMAL(10, 2),
    MaxDiscountAmount DECIMAL(10, 2),
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    UsageLimit INT, -- số lượt sử dụng tối đa
    UsageCount INT DEFAULT 0, -- số lượt đã sử dụng
    Status ENUM('Active', 'Expired', 'Disabled') DEFAULT 'Active'
);

CREATE TABLE CustomerVouchers (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    VoucherID INT NOT NULL,
    IsUsed BOOLEAN DEFAULT FALSE,
    UsedAt TIMESTAMP NULL,

    CONSTRAINT fk_cv_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID),
    CONSTRAINT fk_cv_voucher FOREIGN KEY (VoucherID) REFERENCES Vouchers(ID),
    UNIQUE (CustomerID, VoucherID) -- tránh gán trùng
);

CREATE TABLE Staff (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    PhoneNumber VARCHAR(20),
    Role VARCHAR(50),
    AssignedLabelID INT,
    AssignedStorageID INT,
    Status ENUM('Active', 'Inactive') DEFAULT 'Active',
    
    CONSTRAINT fk_staff_label FOREIGN KEY (AssignedLabelID) REFERENCES Labels(ID),
    CONSTRAINT fk_staff_storage FOREIGN KEY (AssignedStorageID) REFERENCES Storages(ID),
    CHECK (
        (AssignedLabelID IS NOT NULL AND AssignedStorageID IS NULL)
        OR
        (AssignedLabelID IS NULL AND AssignedStorageID IS NOT NULL)
    )
);

CREATE TABLE OrderRequests (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    LabelID INT,
    SurveyStaffID INT,
    SurveyDate DATE,
    StorageID INT,
    PickUpLocation VARCHAR(250),
    DeliveryLocation VARCHAR(250),
    Transport VARCHAR(100),
    PickUpDate DATE,
    ExpectedDeliveryTime DATETIME,
    TotalAmount DECIMAL(10, 2),

    CONSTRAINT fk_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID),
    CONSTRAINT fk_label FOREIGN KEY (LabelID) REFERENCES Labels(ID),
    CONSTRAINT fk_storage FOREIGN KEY (StorageID) REFERENCES Storages(ID),
CONSTRAINT fk_survey_staff FOREIGN KEY (SurveyStaffID) REFERENCES Staff(ID)
);

CREATE TABLE OrderTracking (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT NOT NULL,
    Status ENUM('Pending', 'Processing', 'Picked Up', 'In Transit', 'Delivered', 'Cancelled', 'Returned') NOT NULL,
    Location VARCHAR(250),
    Notes TEXT,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_tracking_order FOREIGN KEY (OrderID) REFERENCES OrderRequests(ID)
);

CREATE TABLE Deliveries (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    OrderID INT NOT NULL,
    LabelID INT NOT NULL,
    DepartureStorageID INT NOT NULL,
    ArrivalAddress VARCHAR(250) NOT NULL,
    DepartureTime DATETIME NOT NULL,
    ArrivalTime DATETIME,
    TransportMode ENUM('Truck', 'Van', 'Bike', 'Air', 'Ship') DEFAULT 'Truck',
    DurationMinutes INT,
    Price DECIMAL(10,2) NOT NULL,
    Status ENUM('Booked', 'In Transit', 'Completed', 'Cancelled') DEFAULT 'Booked',
    TrackingCode VARCHAR(100) UNIQUE,

    CONSTRAINT fk_delivery_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID),
    CONSTRAINT fk_delivery_order FOREIGN KEY (OrderID) REFERENCES OrderRequests(ID),
    CONSTRAINT fk_delivery_label FOREIGN KEY (LabelID) REFERENCES Labels(ID),
    CONSTRAINT fk_departure_storage FOREIGN KEY (DepartureStorageID) REFERENCES Storages(ID)
);

CREATE TABLE Payments (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    OrderID INT NOT NULL,
    TotalAmount DECIMAL(10, 2) NOT NULL,
    PaymentDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    PaymentMethod ENUM('Cash', 'Credit Card', 'Bank Transfer', 'E-Wallet') NOT NULL,
    Status ENUM('Pending', 'Completed', 'Failed') DEFAULT 'Completed',

    CONSTRAINT fk_payment_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID),
    CONSTRAINT fk_payment_order FOREIGN KEY (OrderID) REFERENCES OrderRequests(ID)
);
CREATE TABLE Issues (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    IncidentCode VARCHAR(50) NOT NULL UNIQUE,
    OrderID INT NOT NULL,
    CustomerID INT NOT NULL,
    IncidentDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Description TEXT,
    Resolution TEXT,
    Status ENUM('Open', 'In Progress', 'Resolved', 'Closed') DEFAULT 'Open',
    
    CONSTRAINT fk_issue_order FOREIGN KEY (OrderID) REFERENCES OrderRequests(ID),
    CONSTRAINT fk_issue_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID)
);

INSERT INTO Roles (RoleName) VALUES 
('Customer'),
('Staff'),
('Admin');

INSERT INTO Customers (
    FullName, Email, PhoneNumber, CitizenID, DateOfBirth, CustomerType, 
    PasswordHash, IsEmailConfirmed, IsDeleted, RoleID
) VALUES
('Trịnh Tiến Hùng', 'hungtrinhtien@gmail.com', '0909123456', NULL, '2005-04-11', 'Regular', 
 '$2a$10$eImiTXuWVxfM37uY4JANjQ==', 1, 0, 1),
('Hoàng Vân Anh', 'anhhoangvan@gmail.com', '0912345678', NULL, '2004-12-21', 'VIP', 
 '$2a$10$7Q7XfQZJ/ZQ5mXOWQeFb0e==', 1, 0, 1),
('Nguyễn Huy Thái', 'thainguyenhuy@gmail.com', '0923456789', NULL, '2002-02-02', 'Regular', 
 '$2a$10$J9N5Yz4b5ZXpAbfOoGvZcO==', 1, 0, 1);
 
 
INSERT INTO Labels (LabelName, Description, ContactInfo, Status) VALUES
('VNPost', 'Dịch vụ chuyển phát nhanh nội địa', '0123456789 - vnpost@example.com', 'Active'),
('Giao Hàng Nhanh', 'Giao hàng trong ngày tại các thành phố lớn', '0934567890 - ghn@example.com', 'Active'),
('J&T Express', 'Chuyển phát nhanh quốc tế', '0987654321 - jtexpress@example.com', 'Inactive');

INSERT INTO Storages (StorageName, Address, Capacity, PricePerMonth, ContactInfo, Status) VALUES
('Kho Hà Nội', '123 Trần Duy Hưng, Hà Nội', 1000, 5000000, '0911222333 - khohn@example.com', 'Available'),
('Kho Đà Nẵng', '456 Nguyễn Văn Linh, Đà Nẵng', 800, 4000000, '0922333444 - khodn@example.com', 'Occupied'),
('Kho Hồ Chí Minh', '789 Điện Biên Phủ, TP.HCM', 1200, 5500000, '0933444555 - kohcm@example.com', 'Maintenance');


INSERT INTO Vouchers (
    Code, Description, DiscountType, DiscountValue, MinOrderAmount, MaxDiscountAmount, 
    StartDate, EndDate, UsageLimit, UsageCount, Status
) VALUES
('WELCOME10', 'Giảm 10% cho đơn đầu tiên', 'Percentage', 10.00, 100000, 50000, '2025-01-01', '2025-12-31', 1000, 10, 'Active'),
('FREESHIP', 'Miễn phí vận chuyển cho đơn trên 200k', 'Fixed', 20000, 200000, 20000, '2025-01-01', '2025-06-30', 500, 100, 'Active'),
('SUMMER50', 'Giảm 50k cho mùa hè', 'Fixed', 50000, 300000, 50000, '2025-06-01', '2025-08-31', 300, 0, 'Active');

INSERT INTO Staff (
    FullName, Email, PhoneNumber, Role, AssignedLabelID, AssignedStorageID, Status
) VALUES
('Nguyễn Văn A', 'nva.staff@example.com', '0901111222', 'Surveyor', 1, NULL, 'Active'),
('Trần Thị B', 'ttb.staff@example.com', '0912333444', 'Storage Manager', NULL, 1, 'Active'),
('Lê Văn C', 'lvc.staff@example.com', '0923444555', 'Logistics', 2, NULL, 'Inactive');


