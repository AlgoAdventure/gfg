def find_authors_multiple_comments(df):
    # Filter rows where the author commented on their own article
    self_comments = df[df['author_id'] == df['viewer_id']]
    
    # Count number of self-comments per author per article
    counts = self_comments.groupby(['author_id', 'article_id']).size().reset_index(name='count')
    
    # Keep only those where self-comments > 1
    frequent_authors = counts[counts['count'] > 1]
    
    # Get unique author IDs and sort them
    result = frequent_authors[['author_id']].drop_duplicates().sort_values('author_id').reset_index(drop=True)
    
    # Rename column to match expected output
    result.columns = ['id']
    
    return result
