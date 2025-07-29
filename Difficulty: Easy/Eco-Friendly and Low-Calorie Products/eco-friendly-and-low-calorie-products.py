def find_eco_low_calorie_products(df):
    # Code here
    filtered_df = df[(df['eco_friendly'] == 'Y') & (df['calories'] <= 200)]
    return filtered_df[['product_id', 'product_name', 'calories']]