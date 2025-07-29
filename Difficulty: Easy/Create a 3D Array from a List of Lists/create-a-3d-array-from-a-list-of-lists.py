import ast
def create_3d_array(data):
    if isinstance(data, str):
        data = ast.literal_eval(data)
    return np.array(data, dtype=int)