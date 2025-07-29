def find_salesperson_without_blue_orders(df_salesperson, df_orders, df_company):
    # Merge orders with company to include company name (avoid column name collision by renaming)
    df_company_renamed = df_company.rename(columns={'name': 'company_name'})
    orders_with_company = df_orders.merge(df_company_renamed, on='com_id', how='left')
    
    # Filter orders where company name is BLUE
    blue_orders = orders_with_company[orders_with_company['company_name'] == 'BLUE']
    
    # Get unique sales_ids who sold to company BLUE
    sales_ids_with_blue_orders = blue_orders['sales_id'].unique()
    
    # Filter out these salespeople from df_salesperson
    result = df_salesperson[~df_salesperson['sales_id'].isin(sales_ids_with_blue_orders)]
    
    # Return only the name column
    return result[['name']]
