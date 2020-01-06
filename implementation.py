from sklearn.decomposition import TruncatedSVD
import numpy as np
from scipy.spatial import distance

feature_matrix = [
    [5, 1, 3, 4],
    [7, 8, 1, 10],
    [3, 9, 2, 1],
    [4, 9, 3, 5],
    [5, 1, 3, 5],
    [10, 9, 2, 7],
    [10, 9, 3, 8],
    [1, 2, 4, 6],
    [4, 8, 3, 2],
    [1, 7, 5, 9],
    [9, 2, 7, 1],
    [10, 4, 3, 1],
    [5, 6, 7, 8],
    [3, 4, 5, 6],
    [8, 6, 4, 2],
    [5, 5, 5, 5],
    [2, 4, 7, 10],
    [2, 9, 9, 4],
    [9, 4, 9, 2],
    [8, 4, 10, 10],
    ]

# uses Singular Value Decomposition to reduce the dimensions to 2 features
svd_model = TruncatedSVD(n_components=2)
reduced_feature_matrix = svd_model.fit_transform(feature_matrix)

subject_subject_similarity_matrix = []

# iterates through each subject in the reduced feature matrix
for query_subject_array in reduced_feature_matrix:

    distances = []
    similarity_scores = []
    for subject_array in reduced_feature_matrix:
        # calculates the euclidean distance 
        dist = distance.euclidean(query_subject_array, subject_array)
        # stores the distances in a list
        distances.append(dist)

    for d in distances:
        score = ((1 - d/max(distances)))
        # formats the score into a percentage with 2 decimals
        score = '{:.2%}'.format(score)
        # stores the similarity scores in a list
        similarity_scores.append(score)

    # adds the similarity scores for a subject into the subject-subject similarity matrix
    subject_subject_similarity_matrix.append(similarity_scores)

for s in subject_subject_similarity_matrix:
    print("Subject #" + str(subject_subject_similarity_matrix.index(s) + 1))
    print(s)
    print()