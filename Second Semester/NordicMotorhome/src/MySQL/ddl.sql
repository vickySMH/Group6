CREATE TABLE IF NOT EXISTS Role
(
    RoleID INTEGER AUTO_INCREMENT PRIMARY KEY,
    Role VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS Position
(
    PositionID INTEGER AUTO_INCREMENT PRIMARY KEY,
    Position VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS User
(
    Username VARCHAR(20) PRIMARY KEY, Password VARCHAR(16),
    RoleID INTEGER, FOREIGN KEY (RoleID) REFERENCES Role(RoleID)

);

CREATE TABLE IF NOT EXISTS Staff
(
    ID INTEGER AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(45), LastName VARCHAR(45), PositionID INTEGER, Username VARCHAR(20),
    FOREIGN KEY (Username) REFERENCES User(Username),
    FOREIGN KEY (PositionID) REFERENCES Position(PositionID)
);

CREATE TABLE IF NOT EXISTS Vehicle
(
    LicenseNumber VARCHAR(7) PRIMARY KEY , Model VARCHAR(100), Fuel INT CHECK (Fuel BETWEEN 0 and 100), Kilometrage INT,
    Beds TINYINT, isClean BOOLEAN, isBroken BOOLEAN
);

CREATE TABLE IF NOT EXISTS Extras
(
    ID INTEGER AUTO_INCREMENT PRIMARY KEY, Extra VARCHAR(30), Quantity INT, Price FLOAT
);

CREATE TABLE IF NOT EXISTS Customer
(
    FirstName VARCHAR(45), LastName VARCHAR(45), PhoneNumber VARCHAR(20) PRIMARY KEY, Username VARCHAR(20),
    FOREIGN KEY (Username) REFERENCES User(Username)
);

CREATE TABLE IF NOT EXISTS Bookings
(
    ID INTEGER AUTO_INCREMENT PRIMARY KEY ,StartDate DATE, EndDate DATE,
    LicenseNumber VARCHAR(7), PhoneNumber VARCHAR(20), Price FLOAT,
    FOREIGN KEY (PhoneNumber) REFERENCES Customer(PhoneNumber),
    FOREIGN KEY (LicenseNumber) REFERENCES Vehicle(LicenseNumber)
);

CREATE TABLE IF NOT EXISTS ExtraDetails
(
    ExtraDetailsID INTEGER AUTO_INCREMENT PRIMARY KEY, BookingID INTEGER, ExtraID INTEGER, Quantity INTEGER,
    FOREIGN KEY (BookingID) REFERENCES Bookings(ID),
    FOREIGN KEY (ExtraID) REFERENCES Extras(ID)
);

CREATE TABLE IF NOT EXISTS OrderDetails
(
    OrderID INTEGER AUTO_INCREMENT PRIMARY KEY, BookingID INTEGER, ExtraDetailsID INTEGER, TotalPrice FLOAT
);