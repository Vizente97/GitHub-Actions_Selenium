import pytest

@pytest.mark.parametrize("input,expected", [
    (1, 2),
    (2, 3),
    (3, 4)
])
def test_increment(input, expected):
    assert input + 1 == expected