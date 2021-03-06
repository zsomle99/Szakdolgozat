USE [master]
GO
/****** Object:  Database [SzakdolgozatDB]    Script Date: 2022. 04. 20. 20:28:01 ******/
CREATE DATABASE [SzakdolgozatDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SzakdolgozatDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\SzakdolgozatDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SzakdolgozatDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\SzakdolgozatDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [SzakdolgozatDB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SzakdolgozatDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SzakdolgozatDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SzakdolgozatDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SzakdolgozatDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SzakdolgozatDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SzakdolgozatDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET RECOVERY FULL 
GO
ALTER DATABASE [SzakdolgozatDB] SET  MULTI_USER 
GO
ALTER DATABASE [SzakdolgozatDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SzakdolgozatDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SzakdolgozatDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SzakdolgozatDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SzakdolgozatDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SzakdolgozatDB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'SzakdolgozatDB', N'ON'
GO
ALTER DATABASE [SzakdolgozatDB] SET QUERY_STORE = OFF
GO
USE [SzakdolgozatDB]
GO
/****** Object:  Table [dbo].[Administrator]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Administrator](
	[ID] [int] NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Level of Administrator] [int] NOT NULL,
	[Position] [varchar](50) NOT NULL,
	[Email] [int] NOT NULL,
 CONSTRAINT [PK_Administrator] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Client]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Client](
	[ID] [int] NOT NULL,
	[Name] [varchar](50) NULL,
	[Place Of Birth] [varchar](50) NULL,
	[Date Of Birth] [date] NULL,
 CONSTRAINT [PK_Client] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Email]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Email](
	[Client ID] [int] NOT NULL,
	[Manager ID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EmailAM]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmailAM](
	[Administrator ID] [int] NOT NULL,
	[Manager ID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Error]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Error](
	[ID] [int] NOT NULL,
	[Since] [date] NOT NULL,
	[Occurence] [int] NOT NULL,
 CONSTRAINT [PK_Error] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Error_Messages]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Error_Messages](
	[Error Messages] [char](20) NOT NULL,
	[ID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Internet]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Internet](
	[Client ID] [int] NOT NULL,
	[Error ID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Mail]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mail](
	[Client ID] [int] NOT NULL,
	[Manager ID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Manager]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager](
	[ID] [int] NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Level of Manager] [int] NOT NULL,
	[Position] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Manager] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhoneAC]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhoneAC](
	[Client ID] [int] NOT NULL,
	[Administrator ID] [int] NOT NULL,
	[Since] [int] NOT NULL,
	[Until] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhoneAM]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhoneAM](
	[Administrator ID] [int] NOT NULL,
	[Manager ID] [int] NOT NULL,
	[Since] [int] NOT NULL,
	[Until] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhoneCE]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhoneCE](
	[Client ID] [int] NOT NULL,
	[Error ID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TV]    Script Date: 2022. 04. 20. 20:28:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TV](
	[Client ID] [int] NOT NULL,
	[Error ID] [int] NOT NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Administrator] ([ID], [Name], [Level of Administrator], [Position], [Email]) VALUES (1, N'Varr Tamás', 1, N'operátor', 1000)
INSERT [dbo].[Administrator] ([ID], [Name], [Level of Administrator], [Position], [Email]) VALUES (2, N'Tamás Imre', 2, N'operátor', 1001)
INSERT [dbo].[Administrator] ([ID], [Name], [Level of Administrator], [Position], [Email]) VALUES (3, N'Nagy Elek', 2, N'operátor', 1002)
INSERT [dbo].[Administrator] ([ID], [Name], [Level of Administrator], [Position], [Email]) VALUES (4, N'Sándor István', 1, N'kiemelt operátor', 1003)
INSERT [dbo].[Administrator] ([ID], [Name], [Level of Administrator], [Position], [Email]) VALUES (5, N'Miklós Iván', 2, N'kiemelt operátor', 1004)
GO
INSERT [dbo].[Client] ([ID], [Name], [Place Of Birth], [Date Of Birth]) VALUES (1, N'Kiss János', N'Miskolc', CAST(N'1992-04-10' AS Date))
INSERT [dbo].[Client] ([ID], [Name], [Place Of Birth], [Date Of Birth]) VALUES (2, N'Szende Pál', N'Nyiregyháza', CAST(N'1988-02-10' AS Date))
INSERT [dbo].[Client] ([ID], [Name], [Place Of Birth], [Date Of Birth]) VALUES (3, N'Nagy Benedek', N'Eger', CAST(N'1967-11-10' AS Date))
INSERT [dbo].[Client] ([ID], [Name], [Place Of Birth], [Date Of Birth]) VALUES (4, N'Sipos Petra', N'Miskolc', CAST(N'1994-03-12' AS Date))
INSERT [dbo].[Client] ([ID], [Name], [Place Of Birth], [Date Of Birth]) VALUES (5, N'Kovács Tamás', N'Debrecen', CAST(N'1999-06-16' AS Date))
GO
INSERT [dbo].[Email] ([Client ID], [Manager ID]) VALUES (1, 1000)
INSERT [dbo].[Email] ([Client ID], [Manager ID]) VALUES (2, 1001)
INSERT [dbo].[Email] ([Client ID], [Manager ID]) VALUES (3, 1003)
INSERT [dbo].[Email] ([Client ID], [Manager ID]) VALUES (4, 1002)
INSERT [dbo].[Email] ([Client ID], [Manager ID]) VALUES (5, 1004)
GO
INSERT [dbo].[EmailAM] ([Administrator ID], [Manager ID]) VALUES (1, 1000)
INSERT [dbo].[EmailAM] ([Administrator ID], [Manager ID]) VALUES (2, 1001)
INSERT [dbo].[EmailAM] ([Administrator ID], [Manager ID]) VALUES (3, 1002)
INSERT [dbo].[EmailAM] ([Administrator ID], [Manager ID]) VALUES (4, 1003)
INSERT [dbo].[EmailAM] ([Administrator ID], [Manager ID]) VALUES (5, 1004)
GO
INSERT [dbo].[Error] ([ID], [Since], [Occurence]) VALUES (1, CAST(N'2019-10-21' AS Date), 3)
INSERT [dbo].[Error] ([ID], [Since], [Occurence]) VALUES (2, CAST(N'2020-04-12' AS Date), 2)
INSERT [dbo].[Error] ([ID], [Since], [Occurence]) VALUES (3, CAST(N'2019-10-27' AS Date), 1)
INSERT [dbo].[Error] ([ID], [Since], [Occurence]) VALUES (4, CAST(N'2020-08-02' AS Date), 6)
INSERT [dbo].[Error] ([ID], [Since], [Occurence]) VALUES (5, CAST(N'2020-05-08' AS Date), 11)
GO
INSERT [dbo].[Error_Messages] ([Error Messages], [ID]) VALUES (N'Nincs jel           ', 1)
INSERT [dbo].[Error_Messages] ([Error Messages], [ID]) VALUES (N'Lefedettség hiba    ', 2)
INSERT [dbo].[Error_Messages] ([Error Messages], [ID]) VALUES (N'Kábelhiba           ', 3)
INSERT [dbo].[Error_Messages] ([Error Messages], [ID]) VALUES (N'Nincs kábel bedugva ', 4)
INSERT [dbo].[Error_Messages] ([Error Messages], [ID]) VALUES (N'Nincs internet!     ', 5)
GO
INSERT [dbo].[Internet] ([Client ID], [Error ID]) VALUES (2, 1)
INSERT [dbo].[Internet] ([Client ID], [Error ID]) VALUES (2, 2)
INSERT [dbo].[Internet] ([Client ID], [Error ID]) VALUES (5, 3)
INSERT [dbo].[Internet] ([Client ID], [Error ID]) VALUES (5, 4)
INSERT [dbo].[Internet] ([Client ID], [Error ID]) VALUES (5, 5)
GO
INSERT [dbo].[Mail] ([Client ID], [Manager ID]) VALUES (1, 1000)
INSERT [dbo].[Mail] ([Client ID], [Manager ID]) VALUES (2, 1001)
INSERT [dbo].[Mail] ([Client ID], [Manager ID]) VALUES (3, 1003)
INSERT [dbo].[Mail] ([Client ID], [Manager ID]) VALUES (4, 1002)
INSERT [dbo].[Mail] ([Client ID], [Manager ID]) VALUES (5, 1004)
GO
INSERT [dbo].[Manager] ([ID], [Name], [Level of Manager], [Position]) VALUES (1000, N'Boldog Péter', 1, N'csoport vezető')
INSERT [dbo].[Manager] ([ID], [Name], [Level of Manager], [Position]) VALUES (1001, N'Dom Edit', 2, N'csoport vezető')
INSERT [dbo].[Manager] ([ID], [Name], [Level of Manager], [Position]) VALUES (1002, N'Kovács Miklós', 1, N'csoport vezető')
INSERT [dbo].[Manager] ([ID], [Name], [Level of Manager], [Position]) VALUES (1003, N'Lakatos Imre', 2, N'csoport vezető')
INSERT [dbo].[Manager] ([ID], [Name], [Level of Manager], [Position]) VALUES (1004, N'Elk Péter', 1, N'csoport vezető')
GO
INSERT [dbo].[PhoneAC] ([Client ID], [Administrator ID], [Since], [Until]) VALUES (1, 1, 10, 15)
INSERT [dbo].[PhoneAC] ([Client ID], [Administrator ID], [Since], [Until]) VALUES (2, 2, 0, 13)
INSERT [dbo].[PhoneAC] ([Client ID], [Administrator ID], [Since], [Until]) VALUES (3, 3, 3, 22)
INSERT [dbo].[PhoneAC] ([Client ID], [Administrator ID], [Since], [Until]) VALUES (4, 4, 50, 55)
INSERT [dbo].[PhoneAC] ([Client ID], [Administrator ID], [Since], [Until]) VALUES (5, 5, 34, 53)
GO
INSERT [dbo].[PhoneAM] ([Administrator ID], [Manager ID], [Since], [Until]) VALUES (1, 1000, 13, 17)
INSERT [dbo].[PhoneAM] ([Administrator ID], [Manager ID], [Since], [Until]) VALUES (2, 1001, 11, 18)
INSERT [dbo].[PhoneAM] ([Administrator ID], [Manager ID], [Since], [Until]) VALUES (3, 1003, 4, 10)
INSERT [dbo].[PhoneAM] ([Administrator ID], [Manager ID], [Since], [Until]) VALUES (4, 1004, 45, 51)
INSERT [dbo].[PhoneAM] ([Administrator ID], [Manager ID], [Since], [Until]) VALUES (5, 1001, 32, 37)
GO
INSERT [dbo].[PhoneCE] ([Client ID], [Error ID]) VALUES (4, 4)
INSERT [dbo].[PhoneCE] ([Client ID], [Error ID]) VALUES (1, 4)
INSERT [dbo].[PhoneCE] ([Client ID], [Error ID]) VALUES (3, 4)
INSERT [dbo].[PhoneCE] ([Client ID], [Error ID]) VALUES (5, 4)
INSERT [dbo].[PhoneCE] ([Client ID], [Error ID]) VALUES (2, 4)
GO
INSERT [dbo].[TV] ([Client ID], [Error ID]) VALUES (1, 3)
INSERT [dbo].[TV] ([Client ID], [Error ID]) VALUES (1, 4)
INSERT [dbo].[TV] ([Client ID], [Error ID]) VALUES (3, 1)
INSERT [dbo].[TV] ([Client ID], [Error ID]) VALUES (3, 3)
INSERT [dbo].[TV] ([Client ID], [Error ID]) VALUES (1, 1)
GO
ALTER TABLE [dbo].[Administrator]  WITH CHECK ADD  CONSTRAINT [FK_Administrator_Manager] FOREIGN KEY([Email])
REFERENCES [dbo].[Manager] ([ID])
GO
ALTER TABLE [dbo].[Administrator] CHECK CONSTRAINT [FK_Administrator_Manager]
GO
ALTER TABLE [dbo].[Email]  WITH CHECK ADD  CONSTRAINT [FK_Email_Client] FOREIGN KEY([Client ID])
REFERENCES [dbo].[Client] ([ID])
GO
ALTER TABLE [dbo].[Email] CHECK CONSTRAINT [FK_Email_Client]
GO
ALTER TABLE [dbo].[Email]  WITH CHECK ADD  CONSTRAINT [FK_Email_Manager] FOREIGN KEY([Manager ID])
REFERENCES [dbo].[Manager] ([ID])
GO
ALTER TABLE [dbo].[Email] CHECK CONSTRAINT [FK_Email_Manager]
GO
ALTER TABLE [dbo].[EmailAM]  WITH CHECK ADD  CONSTRAINT [FK_EmailAM_Administrator] FOREIGN KEY([Administrator ID])
REFERENCES [dbo].[Administrator] ([ID])
GO
ALTER TABLE [dbo].[EmailAM] CHECK CONSTRAINT [FK_EmailAM_Administrator]
GO
ALTER TABLE [dbo].[EmailAM]  WITH CHECK ADD  CONSTRAINT [FK_EmailAM_Manager] FOREIGN KEY([Manager ID])
REFERENCES [dbo].[Manager] ([ID])
GO
ALTER TABLE [dbo].[EmailAM] CHECK CONSTRAINT [FK_EmailAM_Manager]
GO
ALTER TABLE [dbo].[Error_Messages]  WITH CHECK ADD  CONSTRAINT [FK_Error_Messages_Error] FOREIGN KEY([ID])
REFERENCES [dbo].[Error] ([ID])
GO
ALTER TABLE [dbo].[Error_Messages] CHECK CONSTRAINT [FK_Error_Messages_Error]
GO
ALTER TABLE [dbo].[Internet]  WITH CHECK ADD  CONSTRAINT [FK_Internet_Client] FOREIGN KEY([Client ID])
REFERENCES [dbo].[Client] ([ID])
GO
ALTER TABLE [dbo].[Internet] CHECK CONSTRAINT [FK_Internet_Client]
GO
ALTER TABLE [dbo].[Internet]  WITH CHECK ADD  CONSTRAINT [FK_Internet_Error] FOREIGN KEY([Error ID])
REFERENCES [dbo].[Error] ([ID])
GO
ALTER TABLE [dbo].[Internet] CHECK CONSTRAINT [FK_Internet_Error]
GO
ALTER TABLE [dbo].[Mail]  WITH CHECK ADD  CONSTRAINT [FK_Mail_Client] FOREIGN KEY([Client ID])
REFERENCES [dbo].[Client] ([ID])
GO
ALTER TABLE [dbo].[Mail] CHECK CONSTRAINT [FK_Mail_Client]
GO
ALTER TABLE [dbo].[Mail]  WITH CHECK ADD  CONSTRAINT [FK_Mail_Manager] FOREIGN KEY([Manager ID])
REFERENCES [dbo].[Manager] ([ID])
GO
ALTER TABLE [dbo].[Mail] CHECK CONSTRAINT [FK_Mail_Manager]
GO
ALTER TABLE [dbo].[PhoneAC]  WITH CHECK ADD  CONSTRAINT [FK_PhoneAC_Administrator] FOREIGN KEY([Administrator ID])
REFERENCES [dbo].[Administrator] ([ID])
GO
ALTER TABLE [dbo].[PhoneAC] CHECK CONSTRAINT [FK_PhoneAC_Administrator]
GO
ALTER TABLE [dbo].[PhoneAC]  WITH CHECK ADD  CONSTRAINT [FK_PhoneAC_Client] FOREIGN KEY([Client ID])
REFERENCES [dbo].[Client] ([ID])
GO
ALTER TABLE [dbo].[PhoneAC] CHECK CONSTRAINT [FK_PhoneAC_Client]
GO
ALTER TABLE [dbo].[PhoneAM]  WITH CHECK ADD  CONSTRAINT [FK_PhoneAM_Administrator] FOREIGN KEY([Administrator ID])
REFERENCES [dbo].[Administrator] ([ID])
GO
ALTER TABLE [dbo].[PhoneAM] CHECK CONSTRAINT [FK_PhoneAM_Administrator]
GO
ALTER TABLE [dbo].[PhoneAM]  WITH CHECK ADD  CONSTRAINT [FK_PhoneAM_Manager] FOREIGN KEY([Manager ID])
REFERENCES [dbo].[Manager] ([ID])
GO
ALTER TABLE [dbo].[PhoneAM] CHECK CONSTRAINT [FK_PhoneAM_Manager]
GO
ALTER TABLE [dbo].[PhoneCE]  WITH CHECK ADD  CONSTRAINT [FK_PhoneCE_Client] FOREIGN KEY([Client ID])
REFERENCES [dbo].[Client] ([ID])
GO
ALTER TABLE [dbo].[PhoneCE] CHECK CONSTRAINT [FK_PhoneCE_Client]
GO
ALTER TABLE [dbo].[PhoneCE]  WITH CHECK ADD  CONSTRAINT [FK_PhoneCE_Error] FOREIGN KEY([Error ID])
REFERENCES [dbo].[Error] ([ID])
GO
ALTER TABLE [dbo].[PhoneCE] CHECK CONSTRAINT [FK_PhoneCE_Error]
GO
ALTER TABLE [dbo].[TV]  WITH CHECK ADD  CONSTRAINT [FK_TV_Client] FOREIGN KEY([Client ID])
REFERENCES [dbo].[Client] ([ID])
GO
ALTER TABLE [dbo].[TV] CHECK CONSTRAINT [FK_TV_Client]
GO
ALTER TABLE [dbo].[TV]  WITH CHECK ADD  CONSTRAINT [FK_TV_Error] FOREIGN KEY([Error ID])
REFERENCES [dbo].[Error] ([ID])
GO
ALTER TABLE [dbo].[TV] CHECK CONSTRAINT [FK_TV_Error]
GO
USE [master]
GO
ALTER DATABASE [SzakdolgozatDB] SET  READ_WRITE 
GO
