ALTER TABLE Reservations
ADD COLUMN customerId INT;

ALTER TABLE Reservations
ADD CONSTRAINT fk_customerId
FOREIGN KEY (customerId) REFERENCES Customer(id);