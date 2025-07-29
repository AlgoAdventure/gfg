import pandas as pd

def find_invalid_comments(comments: pd.DataFrame) -> pd.DataFrame:
    return comments[comments['content'].str.len() > 20][['comment_id']]