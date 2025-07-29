def delete_duplicate_phone_numbers(df):
    df = df.sort_values(by='id')
    df_final = df.drop_duplicates(subset='phone', keep='first')
    return df_final
