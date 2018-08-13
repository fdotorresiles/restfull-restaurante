/*
Punto 1,
Autor: Luis Torres Siles
*/

IF OBJECT_ID('TOTAL_CLIENTES_MALOS', 'V') IS NOT NULL
	DROP VIEW TOTAL_CLIENTES_MALOS
GO

CREATE VIEW TOTAL_CLIENTES_MALOS 
AS
SELECT  
		cus.CustomerID,
		cus.PersonID

	FROM Sales.Customer cus

	FULL OUTER JOIN Sales.SalesOrderHeader shead
		ON cus.CustomerID = shead.CustomerID

	WHERE shead.CustomerID IS NULL

GO

/*
Punto 2,
Autor: Luis Torres Siles
*/

SELECT *
	FROM TOTAL_CLIENTES_MALOS

GO

DECLARE 
@productId int, @productName VARCHAR(50), @productColor NVARCHAR(15), @productListPrice MONEY,
@subCateName VARCHAR(50), @categoryName VARCHAR(50), @modelName VARCHAR(50)

DECLARE db_cursor CURSOR FOR

SELECT 
	prod.ProductID, 
	prod.Name, 
	prod.Color, 
	prod.ListPrice, 
	subCate.Name, 
	cate.Name, 
	model.Name FROM 
		Production.Product prod, 
		Production.ProductSubcategory subCate, 
		Production.ProductCategory cate, 
		Production.ProductModel model
		WHERE 
		prod.ProductSubcategoryID = subCate.ProductSubcategoryID AND
		subCate.ProductCategoryID = cate.ProductCategoryID AND
		prod.ProductModelID = model.ProductModelID

		ORDER BY prod.ListPrice ASC

OPEN db_cursor   
FETCH NEXT FROM db_cursor INTO @productId, @productName, @productColor, @productListPrice,
@subCateName, @categoryName, @modelName

WHILE @@FETCH_STATUS = 0   
BEGIN   
		PRINT
			CONCAT(
				'PRODUCT ID: ', @productId, '-',
				'PRODUCT NAME: ', @productName, '-',
				'PRODUCT COLOR: ', @productColor, '-',
				'PRODUCT PRICE: ', @productListPrice, '-',
				'SUB CATEGORY: ', @subCateName, '-',
				'CATEGORY: ', @categoryName, '-',
				'MODEL: ', @modelName, '-',
				'DESCUENTO: ', 
					(CASE 
						WHEN @productListPrice >= 0 and @productListPrice < 85 THEN '-NO TIENE DESC'
						WHEN @productListPrice >= 86 and @productListPrice < 123 THEN '-5% DESC'
						WHEN @productListPrice >= 124 THEN '-10% DESC'
					END)
			)

		FETCH NEXT FROM db_cursor INTO @productId, @productName, @productColor, @productListPrice,
		@subCateName, @categoryName, @modelName
END   

CLOSE db_cursor;
DEALLOCATE db_cursor;

/*
Punto 3,
Autor: Luis Torres Siles
*/

IF OBJECT_ID('PRODUCTOS_SIN_REVIEW', 'FN') IS NOT NULL
	DROP FUNCTION PRODUCTOS_SIN_REVIEW
GO

CREATE FUNCTION PRODUCTOS_SIN_REVIEW ()
RETURNS INT
AS BEGIN
    DECLARE @productCount INT
    SET @productCount = 
		(SELECT COUNT(1) 
			FROM Production.ProductReview prodRev

			RIGHT OUTER JOIN Production.Product prod
				ON  prodRev.ProductID = prod.ProductID

			WHERE prodRev.ProductReviewID IS NULL)

    RETURN @productCount
END	

GO

PRINT dbo.PRODUCTOS_SIN_REVIEW()

/*
Punto 4,
Autor: Luis Torres Siles
*/

IF OBJECT_ID('Calculo_Pago_Vacaciones', 'P') IS NOT NULL
	DROP PROCEDURE Calculo_Pago_Vacaciones
GO

CREATE PROCEDURE Calculo_Pago_Vacaciones 
@Fecha1 DATE, 
@Fecha2 DATE,
@Salario DECIMAL
AS
BEGIN TRY
	DECLARE @monthDiff INT

	SET @monthDiff = DATEDIFF(month, @Fecha1, @Fecha2);
	IF @monthDiff < 1 OR @monthDiff > 12
	BEGIN
		RAISERROR ('Invalid date values',10,1);
		RETURN;
	END
	PRINT @monthDiff;
	SELECT (@Salario * @monthDiff) / 12 AS 'RESULT';
END TRY
BEGIN CATCH
    SELECT ERROR_NUMBER() AS ErrorNumber;
END CATCH;
GO


EXEC Calculo_Pago_Vacaciones @Fecha1 = '01-05-2012', @Fecha2 = '04-01-2012', @Salario = 500000

/*
Punto 5,
Autor: Luis Torres Siles
*/

IF OBJECT_ID('PRODUCTOS_SIN_REVIEW', 'FN') IS NOT NULL
	DROP FUNCTION PRODUCTOS_SIN_REVIEW
GO

CREATE FUNCTION PRODUCTOS_SIN_REVIEW ()
RETURNS INT
AS BEGIN
    DECLARE @productCount INT
    SET @productCount = 
		(SELECT COUNT(1) 
			FROM Production.Product prod
			LEFT OUTER JOIN Production.ProductReview prodRev
				ON prod.ProductID = prodRev.ProductID

			WHERE prodRev.ProductReviewID IS NULL)

    RETURN @productCount
END	

GO

PRINT dbo.PRODUCTOS_SIN_REVIEW()