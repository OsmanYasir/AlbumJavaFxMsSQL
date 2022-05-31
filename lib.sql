USE [master]
GO
/****** Object:  Database [lib]    Script Date: 2022-06-01 2:58:59 AM ******/
CREATE DATABASE [lib]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'lib', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\lib.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'lib_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\lib_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [lib] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [lib].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [lib] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [lib] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [lib] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [lib] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [lib] SET ARITHABORT OFF 
GO
ALTER DATABASE [lib] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [lib] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [lib] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [lib] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [lib] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [lib] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [lib] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [lib] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [lib] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [lib] SET  DISABLE_BROKER 
GO
ALTER DATABASE [lib] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [lib] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [lib] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [lib] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [lib] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [lib] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [lib] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [lib] SET RECOVERY FULL 
GO
ALTER DATABASE [lib] SET  MULTI_USER 
GO
ALTER DATABASE [lib] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [lib] SET DB_CHAINING OFF 
GO
ALTER DATABASE [lib] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [lib] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [lib] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [lib] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'lib', N'ON'
GO
ALTER DATABASE [lib] SET QUERY_STORE = OFF
GO
USE [lib]
GO
/****** Object:  Schema [lib]    Script Date: 2022-06-01 2:58:59 AM ******/
CREATE SCHEMA [lib]
GO
/****** Object:  Table [lib].[songs]    Script Date: 2022-06-01 2:58:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [lib].[songs](
  [id] [int] NOT NULL,
  [artist] [nvarchar](45) NULL,
  [album] [nvarchar](45) NULL,
  [genre] [nvarchar](45) NULL,
  [year] [int] NULL,
 CONSTRAINT [PK_songs_id] PRIMARY KEY CLUSTERED 
(
  [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [lib].[songs] ADD  DEFAULT (NULL) FOR [artist]
GO
ALTER TABLE [lib].[songs] ADD  DEFAULT (NULL) FOR [album]
GO
ALTER TABLE [lib].[songs] ADD  DEFAULT (NULL) FOR [genre]
GO
ALTER TABLE [lib].[songs] ADD  DEFAULT (NULL) FOR [year]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'lib.songs' , @level0type=N'SCHEMA',@level0name=N'lib', @level1type=N'TABLE',@level1name=N'songs'
GO
USE [master]
GO
ALTER DATABASE [lib] SET  READ_WRITE 
GO