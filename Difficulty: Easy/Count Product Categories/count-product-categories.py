def count_product_categories(df):
    result = df.groupby('category_name').size().reset_index(name='products_count')
    result = result.sort_values(by='category_name').reset_index(drop=True)
    return result
