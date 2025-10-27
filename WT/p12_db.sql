SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

SET NAMES utf8mb4;
CREATE TABLE `department` (
  `DeptID` varchar(6) NOT NULL,
  `DeptName` varchar(50) NOT NULL,
  `NOS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `department` (`DeptID`, `DeptName`, `NOS`) VALUES
('104', '🎅 CSE - Code with Shinchan', 61),
('105', '🎄 ECE - Electric Masao Elves', 65),
('106', '☃️ EEE - Energy by Kazama', 52),
('114', '🎁 MECH - Bo-chan Mechanics', 125),
('115', '🦌 MATH - Nene’s Logical Reindeer', 120),
('150', '🛷 AERO - Sleigh Dynamics Dept', 25),
('187', '🍰 HOME-SCI - Misae’s Cookie Science', 20);

CREATE TABLE `marks` (
  `RegNo` varchar(13) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Dept` varchar(5) NOT NULL,
  `CGPA` float NOT NULL,
  `Scholarship` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `marks` (`RegNo`, `Name`, `Dept`, `CGPA`, `Scholarship`) VALUES
('311113104001', '🎅 Shinchan Nohara', 'CSE', 8, 'YES 🍫'),
('311113104002', '🎄 Kazama Toru', 'EEE', 9.1, 'YES 🎁'),
('311113105003', '🧣 Nene Sakurada', 'ECE', 8.7, 'YES 🦌'),
('311113114004', '⛄ Bo-chan', 'MECH', 9.0, 'YES 🧊'),
('311113115005', '🎁 Masao Sato', 'MATH', 8.0, 'YES 🍰'),
('311113150006', '🦌 Himawari Claus', 'AERO', 9.3, 'YES ✨'),
('311113187007', '🎀 Misae Nohara', 'HOME', 7, 'NO 🎅');

ALTER TABLE `department`
  ADD PRIMARY KEY (`DeptID`);

COMMIT;
