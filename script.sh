#!/bin/bash
branch_name="feature/burak"
if [[ $branch_name == feature* ]]; then
          echo "Branch name starts with 'feature/' or 'fix/'."
          else
          echo "Branch name should start with 'feature/' or 'fix/'."
          exit 1
          fi
