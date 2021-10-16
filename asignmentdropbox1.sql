-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2021 at 04:46 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asignmentdropbox1`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` int(3) NOT NULL,
  `username` text NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `newPassword` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `username`, `email`, `password`, `newPassword`) VALUES
(1, 'Admin', 'admin01@pb.edu.bn', 'Testing123', 'Adminpb01');

-- --------------------------------------------------------

--
-- Table structure for table `assignment`
--

CREATE TABLE `assignment` (
  `asgID` int(3) NOT NULL,
  `asgTitle` varchar(100) NOT NULL,
  `asgDescription` varchar(225) NOT NULL,
  `totalW` int(2) NOT NULL,
  `dueDate` date NOT NULL,
  `dueTime` time NOT NULL,
  `noOfStudent` int(7) NOT NULL,
  `moduleID` int(3) NOT NULL,
  `lecturerID` int(3) NOT NULL,
  `groupCode` varchar(50) NOT NULL,
  `moduleCode` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assignment`
--

INSERT INTO `assignment` (`asgID`, `asgTitle`, `asgDescription`, `totalW`, `dueDate`, `dueTime`, `noOfStudent`, `moduleID`, `lecturerID`, `groupCode`, `moduleCode`) VALUES
(601, 'Mathematics', 'Testing', 20, '2021-08-23', '16:00:00', 1, 401, 101, 'DISS04, DWD09', 'A1111'),
(602, 'Effective Communication', 'Essay - Individual assignment about effective communication used in education industry', 40, '2021-11-28', '12:00:00', 1, 402, 102, 'DISS04', 'B2222'),
(603, 'Melayu Islam Beraja: Topik 1', 'Testing', 40, '2021-09-05', '16:00:00', 1, 403, 103, 'DISS04,DITN08', 'C3333'),
(604, 'Emerging Technologies', 'Individual Assignment where student need to do their research about modern technologies', 20, '2021-11-30', '12:00:00', 1, 404, 102, 'DISS04', 'D4444'),
(606, 'Basic Web Programming', 'Building E-Commerce Website', 20, '2021-10-05', '23:59:00', 2, 407, 102, 'DWDT09', 'G7777');

-- --------------------------------------------------------

--
-- Table structure for table `groupcode`
--

CREATE TABLE `groupcode` (
  `groupCodeID` int(3) NOT NULL,
  `groupCode` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `groupcode`
--

INSERT INTO `groupcode` (`groupCodeID`, `groupCode`) VALUES
(201, 'DISS04'),
(202, 'DITN08'),
(203, 'DWD09');

-- --------------------------------------------------------

--
-- Table structure for table `holidays`
--

CREATE TABLE `holidays` (
  `holidayName` text NOT NULL,
  `holidayDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `holidays`
--

INSERT INTO `holidays` (`holidayName`, `holidayDate`) VALUES
('New Years Day', '2021-01-01'),
('Lunar New Year', '2021-02-13'),
('Brunei National Day', '2021-02-23'),
('Prophet\'s Ascension', '2021-03-11'),
('First day of Ramadan', '2021-04-13'),
('Nuzul Al-Quran', '2021-04-28'),
('Eid al-Fitr', '2021-05-13'),
('Royal Brunei Armed Forces Day', '2021-05-31'),
('His Majesty the Sultan\'s Birthday', '2021-07-15'),
('Eid al-Adha', '2021-10-06'),
('Islamic New Year', '2021-08-10'),
('Prophet\'s Birthday', '2021-10-18'),
('looo', '2021-10-11'),
('New Years Day', '2021-01-01'),
('Lunar New Year', '2021-02-13'),
('Brunei National Day', '2021-02-23'),
('Prophet\'s Ascension', '2021-03-11'),
('First day of Ramadan', '2021-04-13'),
('Nuzul Al-Quran', '2021-04-28'),
('Eid al-Fitr', '2021-05-13'),
('Royal Brunei Armed Forces Day', '2021-05-31'),
('His Majesty the Sultan\'s Birthday', '2021-07-15'),
('Eid al-Adha', '2021-10-06'),
('Islamic New Year', '2021-08-10'),
('Prophet\'s Birthday', '2021-10-18'),
('looo', '2021-10-11');

-- --------------------------------------------------------

--
-- Table structure for table `intake`
--

CREATE TABLE `intake` (
  `intakeID` int(3) NOT NULL,
  `intake` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `intake`
--

INSERT INTO `intake` (`intakeID`, `intake`) VALUES
(1, 8),
(2, 9),
(3, 10);

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

CREATE TABLE `lecturer` (
  `lecturerID` int(3) NOT NULL,
  `firstName` text NOT NULL,
  `lastName` text NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `defaultPs` varchar(16) NOT NULL,
  `active` bit(1) NOT NULL,
  `schoolID` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lecturer`
--

INSERT INTO `lecturer` (`lecturerID`, `firstName`, `lastName`, `email`, `password`, `defaultPs`, `active`, `schoolID`) VALUES
(101, 'Aziz', 'Sahbireen', 'aziz.tammid@pb.edu.bn', 'Mouse19', 'Lecturerpoli01', b'1', 501),
(102, 'Amal', 'Musa', 'amal.musa@pb.edu.bn', 'Minutes20', 'Lecturerpoli02', b'1', 502),
(103, 'Bahit', 'Hamid', 'bahit.hamid@pb.edu.bn', 'Clock21', 'Lecturerpoli03', b'1', 501);

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `moduleID` int(3) NOT NULL,
  `moduleCode` varchar(10) NOT NULL,
  `moduleName` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`moduleID`, `moduleCode`, `moduleName`) VALUES
(401, 'A1111', 'Mathematics'),
(402, 'B2222', 'Communication Skills'),
(403, 'C3333', 'Melayu Islam Beraja'),
(404, 'D4444', 'Emerging Technologies'),
(405, 'E5555', 'System Operations'),
(406, 'F6666', 'Database Design and Implementation'),
(407, 'G7777', 'Basic Web Programming'),
(408, 'H8888', 'Introduction to Programming'),
(409, 'I9999', 'Network Fundamentals'),
(410, 'J1010', 'User Experience Design'),
(411, 'K1212', 'Pendidikan Islam'),
(412, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `modulegroup`
--

CREATE TABLE `modulegroup` (
  `mgID` int(3) NOT NULL,
  `moduleID` int(3) NOT NULL,
  `groupCodeID` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modulegroup`
--

INSERT INTO `modulegroup` (`mgID`, `moduleID`, `groupCodeID`) VALUES
(1, 401, 201),
(2, 402, 201),
(3, 403, 202),
(4, 407, 203);

-- --------------------------------------------------------

--
-- Table structure for table `modulelecturer`
--

CREATE TABLE `modulelecturer` (
  `mlID` int(3) NOT NULL,
  `moduleID` int(3) NOT NULL,
  `lecturerID` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modulelecturer`
--

INSERT INTO `modulelecturer` (`mlID`, `moduleID`, `lecturerID`) VALUES
(1, 401, 101),
(2, 402, 102),
(3, 404, 102),
(4, 407, 102);

-- --------------------------------------------------------

--
-- Table structure for table `modulestudent`
--

CREATE TABLE `modulestudent` (
  `msID` int(3) NOT NULL,
  `studentID` varchar(10) NOT NULL,
  `moduleID` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modulestudent`
--

INSERT INTO `modulestudent` (`msID`, `studentID`, `moduleID`) VALUES
(1, '18FTT1601', 401),
(2, '18FTT1601', 403),
(3, '18FTT1601', 404),
(4, '18FTT1602', 401),
(5, '18FTT1602', 403),
(6, '18FTT1602', 404),
(7, '18FTT1608', 401),
(8, '18FTT1608', 403),
(9, '18FTT1608', 404),
(10, '18FTT1620', 405),
(11, '18FTT1620', 409),
(12, '18FTT1620', 408),
(13, '18FTT1654', 405),
(14, '18FTT1654', 409),
(15, '18FTT1654', 408),
(16, '18FTT1705', 405),
(17, '18FTT1705', 409),
(18, '18FTT1705', 408),
(19, '19FTT1601', 403),
(20, '19FTT1601', 406),
(21, '19FTT1601', 407),
(22, '19FTT1602', 403),
(23, '19FTT1602', 406),
(24, '19FTT1602', 407),
(25, '19FTT1603', 403),
(26, '19FTT1603', 406),
(27, '19FTT1603', 407);

-- --------------------------------------------------------

--
-- Table structure for table `program`
--

CREATE TABLE `program` (
  `programID` int(3) NOT NULL,
  `programTitle` text NOT NULL,
  `SchoolID` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `program`
--

INSERT INTO `program` (`programID`, `programTitle`, `SchoolID`) VALUES
(301, 'Level 5 Diploma in Information Technology', 501),
(302, 'Level 5 Diploma in Web Development', 501),
(303, 'Level 5 Diploma in IT Network', 501),
(304, 'Level 5 Diploma in Digital Media', 501),
(305, 'Level 5 Diploma in Business Accounting and Finance', 502),
(306, 'Level 5 Diploma in Business Studies', 502),
(307, 'Level 5 in Diploma in Architecture', 504),
(308, 'Level 5 Diploma in Civil Engineering', 504),
(309, 'Level 5 Diploma in Health Science (Midwifery)', 503),
(310, 'Level 5 Diploma in Health Science (Nursing)', 503);

-- --------------------------------------------------------

--
-- Table structure for table `school`
--

CREATE TABLE `school` (
  `schoolID` int(3) NOT NULL,
  `school` text NOT NULL,
  `ProgramID` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `school`
--

INSERT INTO `school` (`schoolID`, `school`, `ProgramID`) VALUES
(501, 'School of Information Communication Technology', 301),
(502, 'School of Business', 305),
(503, 'School of Health Science', 309),
(504, 'School of Science and Engineering', 307),
(505, 'School of Petrochemical', 0);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentID` varchar(10) NOT NULL,
  `firstName` text NOT NULL,
  `lastName` text NOT NULL,
  `intakeID` int(3) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `defaultPs` varchar(16) NOT NULL,
  `active` bit(1) NOT NULL,
  `groupCodeID` varchar(6) NOT NULL,
  `programID` int(3) NOT NULL,
  `schoolID` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentID`, `firstName`, `lastName`, `intakeID`, `email`, `password`, `defaultPs`, `active`, `groupCodeID`, `programID`, `schoolID`) VALUES
('18FTT1601', 'Nora ', 'Danish', 1, '18FTT1601@student.pb.edu.bn', 'Danish01', 'Studentpoli01', b'1', 'DISS04', 301, 501),
('18FTT1602', 'Karuleza', 'sambas', 1, '18FTT1602@student.pb.edu.bn', 'Karuleza02', 'Studentpoli09', b'1', 'DISS04', 301, 501),
('18FTT1603', 'Adil', 'Khan', 1, '18FTT1603@student.pb.edu.bn', 'Adilkhan01', 'Studentpoli10', b'1', 'DISS04', 301, 501),
('18FTT1604', 'Ikhwan', 'Ahmad', 1, '18FTT1604@student.pb.edu.bn', 'Ikhwan04', 'Studentpoli11', b'1', 'DISS04', 301, 501),
('18FTT1605', 'Fathan', 'Ibrahim', 1, '18FTT1605@student.pb.edu.bn', 'Fathan05', 'Studentpoli12', b'1', 'DISS04', 301, 501),
('18FTT1606', 'Nurin', 'Nabilah', 1, '18FTT1606@student.pb.edu.bn', 'Nabilah06', 'Studentpoli13', b'1', 'DISS04', 301, 501),
('18FTT1607', 'Hidayatul', 'Zainal', 1, '18FTT1607@student.pb.edu.bn', 'Hidayatul07', 'Studentpoli14', b'1', 'DISS04', 301, 501),
('18FTT1608', 'Basirah', 'Untong', 1, '18FTT1608@student.pb.edu.bn', 'Basirah06', 'Studentpoli08', b'1', 'DISS04', 301, 501),
('18FTT1609', 'Ahmad', 'Albab', 1, '18FTT1609@student.pb.edu.bn', 'Ahmad09', 'Studentpoli15', b'1', 'DISS04', 301, 501),
('18FTT1610', 'Faiz', 'Adul', 1, '18FTT1610@student.pb.edu.bn', 'Faiz10', 'Studentpoli16', b'1', 'DISS04', 301, 501),
('18FTT1620', 'Hazirah', 'Musa', 1, '18FTT1620@student.pb.edu.bn', 'Brunei321', 'Studentpoli02', b'1', 'DITN08', 303, 501),
('18FTT1621', 'Yaya', 'Zahir', 1, '18FTT1621@student.pb.edu.bn', 'yaya21', 'Studentpoli17', b'1', 'DITN08', 303, 501),
('18FTT1622', 'Adrianna', 'Iqbal', 1, '18FTT1622@student.pb.edu.bn', 'adrianna', 'Studentpoli18', b'1', 'DITN08', 303, 501),
('18FTT1623', 'Shidah', 'Raihan', 1, '18FTT1623@student.pb.edu.bn', 'shidah23', 'Studentpoli19', b'1', 'DITN08', 303, 501),
('18FTT1624', 'Alzam', 'Muiz', 1, '18FTT1624@student.pb.edu.bn', 'Alzam24', 'Studentpoli20', b'1', 'DITN08', 303, 501),
('18FTT1625', 'Aqilah', 'Jeffry', 1, '18FTT1625@student.pb.edu.bn', 'Aqilah25', 'Studentpoli21', b'1', 'DITN08', 303, 501),
('18FTT1626', 'Adrian ', 'Mahmud', 1, '18FTT1626@student.pb.edu.bn', 'Adrian26', 'Studentpoli22', b'1', 'DITN08', 303, 501),
('18FTT1627', 'Zulfadhli', 'Zainul', 1, '18FTT1627@student.pb.edu.bn', 'Zulfadhli27', 'Studentpoli23', b'1', 'DITN08', 303, 501),
('18FTT1654', 'Hazim', 'Abdullah', 1, '18FTT1654@student.pb.edu.bn', 'Ayam321', 'Studentpoli03', b'1', 'DITN08', 303, 501),
('18FTT1705', 'Maserna', 'Mohammad Helmi', 1, '18FTT1705@student.pb.edu.bn', 'Double321', 'Studentpoli04', b'1', 'DITN08', 303, 501),
('19FTT1601', 'Remy ', 'Ishak', 2, '19FTT1601@student.pb.edu.bn', 'Remy01', 'Studentpoli05', b'1', 'DWT09', 302, 501),
('19FTT1602', 'Syafiq ', 'Kyle', 2, '19FTT1602@student.pb.edu.bn', 'Syafiq321', 'Studentpoli06', b'1', 'DWT09', 302, 501),
('19FTT1603', 'Daiyan ', 'Triysha', 2, '19FTT1603@student.pb.edu.bn', 'Daiyan15', 'Studentpoli07', b'1', 'DWT09', 302, 501),
('19FTT1604', 'Siti', 'Fatimah', 2, '19FTT1604@student.pb.edu.bn', 'Supra345', 'Studentpoli08', b'1', 'DWT09', 302, 501),
('19FTT1605', 'Nurul', 'Firzanah', 2, '19FTT1605@student.pb.edu.bn', 'Integra123', 'Studentpoli09', b'1', 'DWT09', 302, 501),
('19FTT1606', 'Nur', 'Batrisyia', 2, '19FTT1606@student.pb.edu.bn', 'Rover123', 'Studentpoli10', b'1', 'DWT09', 302, 501),
('19FTT1607', 'Mohd', 'Idlan', 2, '19FTT1607@student.pb.edu.bn', 'What234', 'Studentpoli11', b'1', 'DWT09', 302, 501),
('19FTT1608', 'Annasya', 'Ifra', 2, '19FTT1608@student.pb.edu.bn', 'Evo12345', 'Studentpoli12', b'1', 'DWT09', 302, 501),
('19FTT1609', 'Muhd', 'Aariz', 2, '19FTT1609@student.pb.edu.bn', 'Acura123', 'Studentpoli13', b'1', 'DWT09', 302, 501),
('19FTT1610', 'Ar-Rayyan', 'shah', 2, '19FTT1610@student.pb.edu.bn', 'Celica123', 'Studentpoli13', b'1', 'DWT09', 302, 501),
('19FTT1652', 'Wafi', 'Osman', 2, '19FTT1652@student.pb.edu.bn', 'Sayang123', 'Student123', b'1', '202', 302, 502);

-- --------------------------------------------------------

--
-- Table structure for table `submission`
--

CREATE TABLE `submission` (
  `qrcodeID` int(10) NOT NULL,
  `submitDate` date NOT NULL,
  `submitTime` time NOT NULL,
  `studentID` varchar(10) NOT NULL,
  `asgID` int(3) NOT NULL,
  `SN01` text NOT NULL,
  `SN02` text NOT NULL,
  `SN03` text NOT NULL,
  `SN04` text NOT NULL,
  `SN05` text NOT NULL,
  `SN06` text NOT NULL,
  `SN07` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `submission`
--

INSERT INTO `submission` (`qrcodeID`, `submitDate`, `submitTime`, `studentID`, `asgID`, `SN01`, `SN02`, `SN03`, `SN04`, `SN05`, `SN06`, `SN07`) VALUES
(0, '2021-08-22', '07:00:00', '18FTT1601', 601, 'Karuleza Sambas', 'Adil Khan', '', '', '', '', ''),
(1, '2021-09-21', '10:00:00', '18FTT1604', 601, 'Fathan Ibrahim', 'Nurin Nabilah', '', '', '', '', ''),
(2, '2021-08-28', '11:00:00', '18FTT1620', 602, 'Hazim Abdullah', '', '', '', '', '', ''),
(3, '2021-08-26', '10:00:00', '18FTT1622', 602, 'Remy Ishak', '', '', '', '', '', ''),
(4, '2021-09-01', '15:00:00', '18FTT1601', 602, 'Nora Danish', '', '', '', '', '', ''),
(5, '2021-11-25', '14:00:00', '18FTT1603', 602, 'Adil Khan', '', '', '', '', '', ''),
(6, '2021-11-27', '11:34:40', '18FTT1602', 602, 'Karuleza sambas', '', '', '', '', '', ''),
(17, '2021-11-27', '05:06:55', '18FTT1605', 604, 'Fathan Ibrahim', '', '', '', '', '', ''),
(18, '2021-11-24', '10:08:12', '19FTT1601', 606, 'Remy Ishak', 'Nurul Firzanah', '', '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `assignment`
--
ALTER TABLE `assignment`
  ADD PRIMARY KEY (`asgID`),
  ADD KEY `assignment_fk0` (`moduleID`),
  ADD KEY `assignment_fk1` (`lecturerID`);

--
-- Indexes for table `groupcode`
--
ALTER TABLE `groupcode`
  ADD PRIMARY KEY (`groupCodeID`);

--
-- Indexes for table `intake`
--
ALTER TABLE `intake`
  ADD PRIMARY KEY (`intakeID`);

--
-- Indexes for table `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`lecturerID`),
  ADD KEY `lecturer_fk0` (`schoolID`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`moduleID`);

--
-- Indexes for table `modulegroup`
--
ALTER TABLE `modulegroup`
  ADD PRIMARY KEY (`mgID`),
  ADD KEY `modulegroup_fk0` (`moduleID`),
  ADD KEY `modulegroup_fk1` (`groupCodeID`);

--
-- Indexes for table `modulelecturer`
--
ALTER TABLE `modulelecturer`
  ADD PRIMARY KEY (`mlID`),
  ADD KEY `modulelecturer_fk1` (`lecturerID`),
  ADD KEY `modulelecturer_fk0` (`moduleID`);

--
-- Indexes for table `modulestudent`
--
ALTER TABLE `modulestudent`
  ADD PRIMARY KEY (`msID`);

--
-- Indexes for table `program`
--
ALTER TABLE `program`
  ADD PRIMARY KEY (`programID`);

--
-- Indexes for table `school`
--
ALTER TABLE `school`
  ADD PRIMARY KEY (`schoolID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentID`),
  ADD KEY `student_fk0` (`groupCodeID`),
  ADD KEY `student_fk1` (`programID`),
  ADD KEY `student_fk2` (`schoolID`),
  ADD KEY `student_fk3` (`intakeID`);

--
-- Indexes for table `submission`
--
ALTER TABLE `submission`
  ADD PRIMARY KEY (`qrcodeID`),
  ADD KEY `submission_fk0` (`studentID`),
  ADD KEY `submission_fk1` (`asgID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `assignment`
--
ALTER TABLE `assignment`
  MODIFY `asgID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=609;

--
-- AUTO_INCREMENT for table `groupcode`
--
ALTER TABLE `groupcode`
  MODIFY `groupCodeID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=204;

--
-- AUTO_INCREMENT for table `intake`
--
ALTER TABLE `intake`
  MODIFY `intakeID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `lecturer`
--
ALTER TABLE `lecturer`
  MODIFY `lecturerID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT for table `module`
--
ALTER TABLE `module`
  MODIFY `moduleID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=413;

--
-- AUTO_INCREMENT for table `modulegroup`
--
ALTER TABLE `modulegroup`
  MODIFY `mgID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `modulelecturer`
--
ALTER TABLE `modulelecturer`
  MODIFY `mlID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `modulestudent`
--
ALTER TABLE `modulestudent`
  MODIFY `msID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `program`
--
ALTER TABLE `program`
  MODIFY `programID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=311;

--
-- AUTO_INCREMENT for table `school`
--
ALTER TABLE `school`
  MODIFY `schoolID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=507;

--
-- AUTO_INCREMENT for table `submission`
--
ALTER TABLE `submission`
  MODIFY `qrcodeID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignment`
--
ALTER TABLE `assignment`
  ADD CONSTRAINT `assignment_fk0` FOREIGN KEY (`moduleID`) REFERENCES `module` (`moduleID`),
  ADD CONSTRAINT `assignment_fk1` FOREIGN KEY (`lecturerID`) REFERENCES `lecturer` (`lecturerID`);

--
-- Constraints for table `lecturer`
--
ALTER TABLE `lecturer`
  ADD CONSTRAINT `lecturer_fk0` FOREIGN KEY (`schoolID`) REFERENCES `school` (`schoolID`);

--
-- Constraints for table `modulegroup`
--
ALTER TABLE `modulegroup`
  ADD CONSTRAINT `modulegroup_fk0` FOREIGN KEY (`moduleID`) REFERENCES `module` (`moduleID`),
  ADD CONSTRAINT `modulegroup_fk1` FOREIGN KEY (`groupCodeID`) REFERENCES `groupcode` (`groupCodeID`);

--
-- Constraints for table `modulelecturer`
--
ALTER TABLE `modulelecturer`
  ADD CONSTRAINT `modulelecturer_fk0` FOREIGN KEY (`moduleID`) REFERENCES `module` (`moduleID`),
  ADD CONSTRAINT `modulelecturer_fk1` FOREIGN KEY (`lecturerID`) REFERENCES `lecturer` (`lecturerID`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_fk1` FOREIGN KEY (`programID`) REFERENCES `program` (`programID`),
  ADD CONSTRAINT `student_fk2` FOREIGN KEY (`schoolID`) REFERENCES `school` (`schoolID`),
  ADD CONSTRAINT `student_fk3` FOREIGN KEY (`intakeID`) REFERENCES `intake` (`intakeID`);

--
-- Constraints for table `submission`
--
ALTER TABLE `submission`
  ADD CONSTRAINT `submission_fk0` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`),
  ADD CONSTRAINT `submission_fk1` FOREIGN KEY (`asgID`) REFERENCES `assignment` (`asgID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
