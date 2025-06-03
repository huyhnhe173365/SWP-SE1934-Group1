CREATE DATABASE IF NOT EXISTS CustomerDB;
USE CustomerDB;

CREATE TABLE Roles (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    RoleName VARCHAR(100) NOT NULL
);

CREATE TABLE Customers (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    PhoneNumber VARCHAR(10),
    CitizenID INT NULL,
    DateOfBirth DATE NULL,
    CustomerType VARCHAR(50),
    PasswordHash VARCHAR(250) NOT NULL,
    IsEmailConfirmed BIT NOT NULL,
    IsDeleted BIT NOT NULL,
    RoleID BIGINT NOT NULL,
    
    CONSTRAINT fk_customer_role FOREIGN KEY (RoleID) REFERENCES Roles(ID)
);

CREATE TABLE EmailConfirmed (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CustomerID BIGINT NOT NULL,
    Token NVARCHAR(255) NOT NULL,
    ExpirationDate DATETIME NOT NULL,

    CONSTRAINT fk_email_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID)
);

CREATE TABLE Labels (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    LabelName VARCHAR(100) NOT NULL UNIQUE,
    Description TEXT,
    ContactInfo VARCHAR(250),
    Status VARCHAR(100)
);

CREATE TABLE Storages (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    StorageName VARCHAR(100) NOT NULL,
    Address VARCHAR(250) NOT NULL,
    Capacity INT,
    PricePerMonth DECIMAL(10, 2),
    ContactInfo VARCHAR(250),
    Status VARCHAR(100)
);

CREATE TABLE Vouchers (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    Code VARCHAR(50) NOT NULL UNIQUE,
    Description TEXT,
    Discount FLOAT(53) NOT NULL,
    Quantity INT NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    Status VARCHAR(100)
);

CREATE TABLE CustomerVouchers (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CustomerID BIGINT NOT NULL,
    VoucherID BIGINT NOT NULL,
    IsUsed BOOLEAN DEFAULT FALSE,
    UsedAt TIMESTAMP NULL,

    CONSTRAINT fk_cv_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID),
    CONSTRAINT fk_cv_voucher FOREIGN KEY (VoucherID) REFERENCES Vouchers(ID),
    UNIQUE (CustomerID, VoucherID)
);

CREATE TABLE Staff (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    PhoneNumber VARCHAR(20),
    AssignedLabelID BIGINT,
    AssignedStorageID BIGINT,
    Status VARCHAR(100),
    
    CONSTRAINT fk_staff_label FOREIGN KEY (AssignedLabelID) REFERENCES Labels(ID),
    CONSTRAINT fk_staff_storage FOREIGN KEY (AssignedStorageID) REFERENCES Storages(ID),
    CHECK (
        (AssignedLabelID IS NOT NULL AND AssignedStorageID IS NULL)
        OR
        (AssignedLabelID IS NULL AND AssignedStorageID IS NOT NULL)
    )
);

CREATE TABLE OrderRequests (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CustomerID BIGINT NOT NULL,
    TrackingNumber VARCHAR(100) UNIQUE,
    LabelID BIGINT,
    SurveyStaffID BIGINT,
    SurveyDate DATE,
    StorageID BIGINT,
    PickUpLocation VARCHAR(250),
    DeliveryLocation VARCHAR(250),
    Transport VARCHAR(100),
    PickUpDate DATE,
    ExpectedDeliveryTime DATETIME,
    TotalAmount DECIMAL(10, 2),
    Status VARCHAR(100) NOT NULL,
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID),
    CONSTRAINT fk_label FOREIGN KEY (LabelID) REFERENCES Labels(ID),
    CONSTRAINT fk_storage FOREIGN KEY (StorageID) REFERENCES Storages(ID),
    CONSTRAINT fk_survey_staff FOREIGN KEY (SurveyStaffID) REFERENCES Staff(ID)
);

CREATE TABLE OrderTracking (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    OrderID BIGINT NOT NULL,
    TrackingNumber VARCHAR(100) NOT NULL,
    Status VARCHAR(100) NOT NULL,
    Location VARCHAR(250),
    Notes TEXT,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_tracking_order FOREIGN KEY (OrderID) REFERENCES OrderRequests(ID)
);

CREATE TABLE Payments (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CustomerID BIGINT NOT NULL,
    OrderID BIGINT NOT NULL,
    TotalAmount DECIMAL(10, 2) NOT NULL,
    PaymentDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    PaymentMethod ENUM('Cash', 'Credit Card', 'Bank Transfer', 'E-Wallet') NOT NULL,
    Status VARCHAR(100) NOT NULL,

    CONSTRAINT fk_payment_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID),
    CONSTRAINT fk_payment_order FOREIGN KEY (OrderID) REFERENCES OrderRequests(ID)
);

CREATE TABLE Issues (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    IncidentCode VARCHAR(50) NOT NULL UNIQUE,
    OrderID BIGINT NOT NULL,
    CustomerID BIGINT NOT NULL,
    IncidentDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Description TEXT,
    Resolution TEXT,
    Status VARCHAR(100) NOT NULL,
    
    CONSTRAINT fk_issue_order FOREIGN KEY (OrderID) REFERENCES OrderRequests(ID),
    CONSTRAINT fk_issue_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID)
);

CREATE TABLE LabelCalendar (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,  
    ScheduleDate DATETIME NOT NULL,
    Price DECIMAL(18,4) NOT NULL,
    LabelID BIGINT NOT NULL,
    OrderID BIGINT,
    IsBooked BOOLEAN NOT NULL DEFAULT FALSE,

    CONSTRAINT fk_calendar_label FOREIGN KEY (LabelID) REFERENCES Labels(ID),
    CONSTRAINT fk_calendar_order FOREIGN KEY (OrderID) REFERENCES OrderRequests(ID)
);

CREATE TABLE StaffCalendar (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    StaffID BIGINT NOT NULL,
    CalendarDate DATE NOT NULL,
    StartTime TIME NOT NULL,
    EndTime TIME NOT NULL,
    TaskType VARCHAR(100),
    OrderID BIGINT,
    Notes TEXT,
    IsAvailable BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_staff_calendar_staff FOREIGN KEY (StaffID) REFERENCES Staff(ID),
    CONSTRAINT fk_staff_calendar_order FOREIGN KEY (OrderID) REFERENCES OrderRequests(ID)
);

CREATE TABLE Feedbacks (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    Rating INT NOT NULL,
    Comment TEXT NOT NULL,
    FeedbackDate DATE NOT NULL,
    IsReply BOOLEAN NOT NULL,
    CustomerID BIGINT NOT NULL,
    OrderRequestID BIGINT,

    CONSTRAINT fk_feedback_customer FOREIGN KEY (CustomerID) REFERENCES Customers(ID),
    CONSTRAINT fk_feedback_order FOREIGN KEY (OrderRequestID) REFERENCES OrderRequests(ID)
);

-- Dữ liệu mẫu

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

INSERT INTO Vouchers (Code, Description, Discount, Quantity, StartDate, EndDate, Status) VALUES
('WELCOME10', 'Giảm 10% cho đơn đầu tiên', 0.10, 1000, '2025-01-01', '2025-12-31', 'Active'),
('FREESHIP',   'Miễn phí vận chuyển cho đơn trên 200k', 0.00, 500, '2025-01-01', '2025-06-30', 'Active'),
('SUMMER50',   'Giảm 50k cho mùa hè',              50000, 300, '2025-06-01', '2025-08-31', 'Active');

INSERT INTO Staff (
    FullName, Email, PhoneNumber, AssignedLabelID, AssignedStorageID, Status
) VALUES
('Nguyễn Văn A', 'nva.staff@example.com', '0901111222', 1, NULL, 'Active'),
('Trần Thị B', 'ttb.staff@example.com', '0912333444', NULL, 1, 'Active'),
('Lê Văn C', 'lvc.staff@example.com', '0923444555', 2, NULL, 'Inactive');
